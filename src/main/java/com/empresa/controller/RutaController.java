package com.empresa.controller;

import com.empresa.entity.Ruta;
import com.empresa.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutas")
@CrossOrigin(origins = "*")
public class RutaController {

    @Autowired
    private RutaService rutaService; // Inyecta la interfaz

    @GetMapping("/buscar")
    public ResponseEntity<List<Ruta>> consultarRutasSeguras(
            @RequestParam Long idOrigen, 
            @RequestParam Long idDestino) {
        
        List<Ruta> rutas = rutaService.buscarRutasSeguras(idOrigen, idDestino);
        
        if (rutas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(rutas);
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<Ruta> registrarRuta(@RequestBody Ruta ruta) {
        Ruta nuevaRuta = rutaService.registrar(ruta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaRuta);
    }
}