package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.UsuarioHasRol;
import com.empresa.entity.UsuarioHasRolPK;

public interface UsuarioHasRolRepository
        extends JpaRepository<UsuarioHasRol, UsuarioHasRolPK> {

}