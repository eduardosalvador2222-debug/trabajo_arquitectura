package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.MiembroCirculo;

public interface MiembroCirculoService {

    public abstract MiembroCirculo registrar(
            MiembroCirculo miembro);

    public abstract List<MiembroCirculo> listarTodos();

    public abstract Optional<MiembroCirculo> buscarPorId(
            Integer idMiembroCirculo);

    public abstract List<MiembroCirculo> listaMiembrosPorCirculo(
            Integer idCirculo);

    public abstract void eliminar(
            Integer idMiembroCirculo);
}