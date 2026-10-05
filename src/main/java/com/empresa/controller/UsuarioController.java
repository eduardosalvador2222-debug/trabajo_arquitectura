package com.empresa.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.dto.UsuarioResponseDto;
import com.empresa.entity.Usuario;
import com.empresa.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<UsuarioResponseDto> registrar(
			@RequestBody Usuario usuario) {

		usuario.setFechaRegistro(LocalDateTime.now());

		UsuarioResponseDto objDto =
				usuarioService.registrar(usuario);

		return new ResponseEntity<>(
				objDto,
				HttpStatus.CREATED);
	}

	@GetMapping("/buscarPorId/{idUsuario}")
	public ResponseEntity<?> buscaPorId(
			@PathVariable int idUsuario) {

		UsuarioResponseDto objDto =
				usuarioService.buscaPorId(idUsuario);

		return ResponseEntity.ok(objDto);
	}

	@PutMapping("/actualizar/{idUsuario}")
	public Usuario actualizar(
			@PathVariable Integer idUsuario,
			@RequestBody Usuario usuario) {

		return usuarioService.actualizar(
				idUsuario,
				usuario);
	}
}