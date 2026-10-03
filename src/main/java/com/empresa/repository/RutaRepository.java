package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.entity.Ruta;

import java.util.List;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {
    
    List<Ruta> findByOrigen_IdLugarAndDestino_IdLugarOrderByPuntajeSeguridadDesc(Long idOrigen, Long idDestino);
}