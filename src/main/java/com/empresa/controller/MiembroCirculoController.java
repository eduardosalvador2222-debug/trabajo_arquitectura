package com.empresa.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.MiembroCirculo;
import com.empresa.service.MiembroCirculoService;

@RestController
@RequestMapping("/api/miembroCirculo")
public class MiembroCirculoController {

    @Autowired
    private MiembroCirculoService service;

    @PostMapping("/registrar")
    public MiembroCirculo registrar(
            @RequestBody MiembroCirculo miembro) {
       miembro.setVinculadoEn(LocalDateTime.now());
        return service.registrar(miembro);
    }

    @GetMapping("/listarTodos")
    public List<MiembroCirculo> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/buscarPorId/{idMiembroCirculo}")
    public Optional<MiembroCirculo> buscarPorId(
            @PathVariable Integer idMiembroCirculo) {

        return service.buscarPorId(idMiembroCirculo);
    }

    @GetMapping("/buscarPorCirculo/{idCirculo}")
    public List<MiembroCirculo> buscarPorCirculo(
            @PathVariable Integer idCirculo) {
           return service.listaMiembrosPorCirculo(idCirculo);
    }

    @DeleteMapping("/eliminar/{idMiembroCirculo}")
    public void eliminar(
            @PathVariable Integer idMiembroCirculo) {
    service.eliminar(idMiembroCirculo);
    }
}