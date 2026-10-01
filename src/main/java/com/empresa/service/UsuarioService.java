package com.empresa.service;

import com.empresa.entity.Usuario;

public interface UsuarioService {

    public abstract Usuario registrar(Usuario usuario);

    public abstract Usuario buscaPorId(Integer idUsuario);

    public abstract Usuario actualizar(Integer idUsuario, Usuario usuario);
}