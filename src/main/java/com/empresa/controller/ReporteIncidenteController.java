package com.empresa.controller;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.ReporteIncidente;
import com.empresa.service.ReporteIncidenteService;

@RestController
@RequestMapping("/api/brandonmejia/reportes")
public class ReporteIncidenteController {

	@Autowired
    private ReporteIncidenteService reporteincidenteService; // Inyecta la interfaz
	
	
    @GetMapping
    public ResponseEntity<List<ReporteIncidente>> listar() {
        List<ReporteIncidente> reportes = reporteincidenteService.listarTodos();
        return new ResponseEntity<>(reportes, HttpStatus.OK);
    }

    
    @GetMapping("/activos")
    public ResponseEntity<List<ReporteIncidente>> listarActivos() {
        List<ReporteIncidente> activos = reporteincidenteService.listarActivos();
        return new ResponseEntity<>(activos, HttpStatus.OK);
    }

    
    @PostMapping
    public ResponseEntity<ReporteIncidente> guardar(@RequestBody ReporteIncidente reporte) {
        ReporteIncidente nuevoReporte = reporteincidenteService.guardar(reporte);
        return new ResponseEntity<>(nuevoReporte, HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<ReporteIncidente> actualizar(@PathVariable Integer id, @RequestBody ReporteIncidente reporte) {
        ReporteIncidente actualizado = reporteincidenteService.actualizar(id, reporte);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        reporteincidenteService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	
	
}
