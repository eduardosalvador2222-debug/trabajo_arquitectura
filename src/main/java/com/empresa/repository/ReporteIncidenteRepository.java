package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.ReporteIncidente;

public interface ReporteIncidenteRepository extends JpaRepository<ReporteIncidente, Integer>{
	
     List<ReporteIncidente> findByEstadoOrderByReportadoEnDesc(String estado);
     
	 ReporteIncidente actualizar(Integer id, ReporteIncidente reporte);
	
}
