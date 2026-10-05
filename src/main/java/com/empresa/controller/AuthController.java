package com.empresa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.dto.UsuarioLoginDto;
import com.empresa.security.JwtProvider;
import com.empresa.security.UsuarioPrincipal;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtProvider jwtProvider;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UsuarioLoginDto loginUsuario) {
		log.info(">>> login >>> " + loginUsuario.getLogin());
		Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getLogin(),loginUsuario.getPassword()));
		log.info(">>> authentication >>> " + authentication);
		log.info(">>> Inicio de Generacion de Token ");
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token =jwtProvider.generateToken(authentication);
		log.info(">>> token >>> " + token);
		UsuarioPrincipal usuario =(UsuarioPrincipal) authentication.getPrincipal();
		log.info(">>> usuario >>> " + usuario.toString());
		Map<String, Object> response =new HashMap<>();
		response.put("bearer", "Bearer");
		response.put("token", token);

		return ResponseEntity.ok(response);
	}
}