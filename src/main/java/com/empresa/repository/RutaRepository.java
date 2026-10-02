package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.entity.Ruta;

import java.util.List;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {
    
    // Consulta por origen y destino ordenando de mayor a menor puntaje de seguridad
    List<Ruta> findByOrigen_IdLugarAndDestino_IdLugarOrderByPuntajeSeguridadDesc(Long idOrigen, Long idDestino);
}