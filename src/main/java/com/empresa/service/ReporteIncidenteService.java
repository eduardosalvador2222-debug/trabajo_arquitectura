package com.empresa.service;

import java.util.List;

import com.empresa.entity.ReporteIncidente;

public interface ReporteIncidenteService {

	public abstract List<ReporteIncidente> listarTodos();
	public abstract List<ReporteIncidente> listarActivos(); 
	public abstract ReporteIncidente guardar(ReporteIncidente reporte);
	public abstract ReporteIncidente actualizar(Integer id, ReporteIncidente reporte);
	public abstract void eliminar(Integer id);
	
}
