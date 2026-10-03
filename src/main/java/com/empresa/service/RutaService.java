package com.empresa.service;

import java.util.List;

import com.empresa.entity.Ruta;

public interface RutaService {
    List<Ruta> buscarRutasSeguras(Long idOrigen, Long idDestino);
    Ruta registrar(Ruta ruta);
}