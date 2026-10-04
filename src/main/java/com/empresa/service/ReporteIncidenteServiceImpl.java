package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.ReporteIncidente;
import com.empresa.repository.ReporteIncidenteRepository;

@Service
public class ReporteIncidenteServiceImpl implements ReporteIncidenteService {

	@Autowired
    private ReporteIncidenteRepository repository;
	
	@Override
    public List<ReporteIncidente> listarTodos() {
        return repository.findAll();
    }

    @Override
    public List<ReporteIncidente> listarActivos() {
        return repository.findByEstadoOrderByReportadoEnDesc("ACTIVO");
    }

    @Override
    public ReporteIncidente guardar(ReporteIncidente reporte) {
        return repository.save(reporte);
    }

    @Override
    public ReporteIncidente actualizar(Integer id, ReporteIncidente reporteActualizado) {
        return repository.findById(id).map(reporteExistente -> {
            reporteExistente.setDescripcion(reporteActualizado.getDescripcion());
            reporteExistente.setEstado(reporteActualizado.getEstado());
            reporteExistente.setTipoIncidente(reporteActualizado.getTipoIncidente());
            return repository.save(reporteExistente);
        }).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
	
}
