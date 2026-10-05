package com.empresa.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Empresa;
import com.empresa.service.EmpresaService;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @PostMapping("/registrar")
    public Empresa registrar(@RequestBody Empresa empresa) {
        empresa.setCreadoEn(LocalDateTime.now());
        return service.registrar(empresa);
    }

    @GetMapping("/listarTodos")
    public List<Empresa> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/buscarPorId/{idEmpresa}")
    public Optional<Empresa> buscarPorId(@PathVariable Integer idEmpresa) {
        return service.buscarPorId(idEmpresa);
    }

    @PutMapping("/actualizar/{idEmpresa}")
    public Empresa actualizar(
            @PathVariable Integer idEmpresa,
            @RequestBody Empresa empresa) {
        return service.actualizar(idEmpresa, empresa);
    }

    @DeleteMapping("/eliminar/{idEmpresa}")
    public void eliminar(@PathVariable Integer idEmpresa) {
        service.eliminar(idEmpresa);
    }
}