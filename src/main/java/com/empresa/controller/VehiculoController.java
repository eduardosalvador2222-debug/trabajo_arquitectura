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

import com.empresa.entity.Vehiculo;
import com.empresa.service.VehiculoService;

@RestController
@RequestMapping("/api/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService service;

    @PostMapping("/registrar")
    public Vehiculo registrar(@RequestBody Vehiculo vehiculo) {
        vehiculo.setCreadoEn(LocalDateTime.now());
        return service.registrar(vehiculo);
    }

    @GetMapping("/listarTodos")
    public List<Vehiculo> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/buscarPorId/{idVehiculo}")
    public Optional<Vehiculo> buscarPorId(@PathVariable Integer idVehiculo) {
        return service.buscarPorId(idVehiculo);
    }

    @GetMapping("/listarPorEmpresa/{idEmpresa}")
    public List<Vehiculo> listarPorEmpresa(@PathVariable Integer idEmpresa) {
        return service.listarPorEmpresa(idEmpresa);
    }

    @PutMapping("/actualizar/{idVehiculo}")
    public Vehiculo actualizar(
            @PathVariable Integer idVehiculo,
            @RequestBody Vehiculo vehiculo) {
        return service.actualizar(idVehiculo, vehiculo);
    }

    @DeleteMapping("/eliminar/{idVehiculo}")
    public void eliminar(@PathVariable Integer idVehiculo) {
        service.eliminar(idVehiculo);
    }
}