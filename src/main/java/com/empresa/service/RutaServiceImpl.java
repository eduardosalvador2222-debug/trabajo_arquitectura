package com.empresa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Ruta;
import com.empresa.repository.RutaRepository;

import java.util.List;

@Service
public class RutaServiceImpl implements RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    @Override
    public List<Ruta> buscarRutasSeguras(Long idOrigen, Long idDestino) {
        return rutaRepository.findByOrigen_IdLugarAndDestino_IdLugarOrderByPuntajeSeguridadDesc(idOrigen, idDestino);
    }
    @Override
    public Ruta registrar(Ruta ruta) {
        // Aquí puedes agregar validaciones previas si lo necesitas, 
        // y luego guardarlo usando el repositorio de Spring Data JPA
        return rutaRepository.save(ruta);
    }
}
