package com.empresa.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.empresa.dto.UsuarioResponseDto;
import com.empresa.entity.Usuario;
import com.empresa.entity.UsuarioHasRol;
import com.empresa.entity.UsuarioHasRolPK;
import com.empresa.repository.UsuarioHasRolRepository;
import com.empresa.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository repository;
	private final UsuarioHasRolRepository usuarioHasRolRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UsuarioResponseDto registrar(Usuario usuario) {

		usuario.setPassword(
				passwordEncoder.encode(usuario.getPassword()));

		Usuario objUsuario = repository.save(usuario);

		UsuarioHasRolPK objPk = new UsuarioHasRolPK();
		objPk.setIdUsuario(objUsuario.getIdUsuario());
		objPk.setIdRol(2);

		UsuarioHasRol objUsuarioHasRol = new UsuarioHasRol();
		objUsuarioHasRol.setUsuarioHasRolPk(objPk);

		usuarioHasRolRepository.save(objUsuarioHasRol);

		UsuarioResponseDto objDto = new UsuarioResponseDto();

		objDto.setIdUsuario(objUsuario.getIdUsuario());

		objDto.setNombreCompleto(
				objUsuario.getNombres()
						.concat(" ")
						.concat(objUsuario.getApellidos()));

		objDto.setDni(objUsuario.getDni());
		objDto.setCorreo(objUsuario.getCorreo());

		return objDto;
	}

	@Override
	public UsuarioResponseDto buscaPorId(int idUsuario) {

		Usuario objUsuario = repository.findById(idUsuario).orElse(null);

		if (objUsuario == null) {

			return null;

		} else {

			UsuarioResponseDto objDto = new UsuarioResponseDto();

			objDto.setIdUsuario(objUsuario.getIdUsuario());

			objDto.setNombreCompleto(
					objUsuario.getNombres()
							.concat(" ")
							.concat(objUsuario.getApellidos()));

			objDto.setDni(objUsuario.getDni());
			objDto.setCorreo(objUsuario.getCorreo());

			return objDto;
		}
	}

	@Override
	public Usuario actualizar(Integer idUsuario, Usuario usuario) {

		usuario.setIdUsuario(idUsuario);

		return repository.save(usuario);
	}
}