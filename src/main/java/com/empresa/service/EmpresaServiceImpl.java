package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Empresa;
import com.empresa.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Empresa registrar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> listarTodos() {
        return empresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> buscarPorId(Integer idEmpresa) {
        return empresaRepository.findById(idEmpresa);
    }

    @Override
    public Empresa actualizar(Integer idEmpresa, Empresa empresa) {
        empresa.setIdEmpresa(idEmpresa);
        return empresaRepository.save(empresa);
    }

    @Override
    public void eliminar(Integer idEmpresa) {
        empresaRepository.deleteById(idEmpresa);
    }
}