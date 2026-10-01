package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.CirculoConfianza;

public interface CirculoConfianzaService {

    public abstract CirculoConfianza registrar(CirculoConfianza circulo);

    public abstract List<CirculoConfianza> listarTodos();

    public abstract Optional<CirculoConfianza> buscarPorId(Integer idCirculo);

    public abstract CirculoConfianza actualizar(Integer idCirculo,CirculoConfianza circulo);

    public abstract void eliminar(Integer idCirculo);
}