package com.empresa.service;

import com.empresa.dto.UsuarioResponseDto;
import com.empresa.entity.Usuario;

public interface UsuarioService {

	public abstract UsuarioResponseDto registrar(Usuario usuario);

	public abstract UsuarioResponseDto buscaPorId(int idUsuario);

	public abstract Usuario actualizar(Integer idUsuario, Usuario usuario);
}