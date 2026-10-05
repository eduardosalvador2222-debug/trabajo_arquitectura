package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Empresa;

public interface EmpresaService {

    public abstract Empresa registrar(Empresa empresa);

    public abstract List<Empresa> listarTodos();

    public abstract Optional<Empresa> buscarPorId(Integer idEmpresa);

    public abstract Empresa actualizar(Integer idEmpresa, Empresa empresa);

    public abstract void eliminar(Integer idEmpresa);
}