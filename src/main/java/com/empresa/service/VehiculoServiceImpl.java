package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Vehiculo;
import com.empresa.repository.VehiculoRepository;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo registrar(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> listarTodos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Optional<Vehiculo> buscarPorId(Integer idVehiculo) {
        return vehiculoRepository.findById(idVehiculo);
    }

    @Override
    public List<Vehiculo> listarPorEmpresa(Integer idEmpresa) {
        return vehiculoRepository.findByEmpresaIdEmpresa(idEmpresa);
    }

    @Override
    public Vehiculo actualizar(Integer idVehiculo, Vehiculo vehiculo) {
        vehiculo.setIdVehiculo(idVehiculo);
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public void eliminar(Integer idVehiculo) {
        vehiculoRepository.deleteById(idVehiculo);
    }
}