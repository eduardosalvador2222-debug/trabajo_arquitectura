package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Vehiculo;

public interface VehiculoService {

    public abstract Vehiculo registrar(Vehiculo vehiculo);

    public abstract List<Vehiculo> listarTodos();

    public abstract Optional<Vehiculo> buscarPorId(Integer idVehiculo);

    public abstract List<Vehiculo> listarPorEmpresa(Integer idEmpresa);

    public abstract Vehiculo actualizar(Integer idVehiculo, Vehiculo vehiculo);

    public abstract void eliminar(Integer idVehiculo);
}