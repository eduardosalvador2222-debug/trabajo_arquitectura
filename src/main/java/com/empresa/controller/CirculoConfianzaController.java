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

import com.empresa.entity.CirculoConfianza;
import com.empresa.service.CirculoConfianzaService;

@RestController
@RequestMapping("/api/circulo")
public class CirculoConfianzaController {

    @Autowired
    private CirculoConfianzaService service;

    @PostMapping("/registrar")
    public CirculoConfianza registrar(
            @RequestBody CirculoConfianza circulo) {

        circulo.setCreadoEn(LocalDateTime.now());

        return service.registrar(circulo);
    }

    @GetMapping("/listarTodos")
    public List<CirculoConfianza> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/buscarPorId/{idCirculo}")
    public Optional<CirculoConfianza> buscarPorId(
            @PathVariable Integer idCirculo) {

        return service.buscarPorId(idCirculo);
    }

    @PutMapping("/actualizar/{idCirculo}")
    public CirculoConfianza actualizar(
            @PathVariable Integer idCirculo,
            @RequestBody CirculoConfianza circulo) {

        return service.actualizar(idCirculo, circulo);
    }

    @DeleteMapping("/eliminar/{idCirculo}")
    public void eliminar(
            @PathVariable Integer idCirculo) {

        service.eliminar(idCirculo);
    }
}