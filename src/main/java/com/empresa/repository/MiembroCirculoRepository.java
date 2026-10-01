package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.MiembroCirculo;

public interface MiembroCirculoRepository
        extends JpaRepository<MiembroCirculo, Integer> {

    @Query(nativeQuery = true,value = "select * from miembro_circulo where id_circulo = ?1")
    public List<MiembroCirculo> listaMiembrosPorCirculo(
            Integer idCirculo);
}