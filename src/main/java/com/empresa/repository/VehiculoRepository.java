package com.empresa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.empresa.entity.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    // Consulta derivada para filtrar los vehículos según la empresa seleccionada
    public abstract List<Vehiculo> findByEmpresaIdEmpresa(Integer idEmpresa);
}