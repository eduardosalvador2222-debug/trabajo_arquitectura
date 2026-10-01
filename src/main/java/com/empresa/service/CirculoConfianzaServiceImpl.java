package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.CirculoConfianza;
import com.empresa.repository.CirculoConfianzaRepository;

@Service
public class CirculoConfianzaServiceImpl implements CirculoConfianzaService {

    @Autowired
    private CirculoConfianzaRepository repository;

    @Override
    public CirculoConfianza registrar(CirculoConfianza circulo) {
        return repository.save(circulo);
    }

    @Override
    public List<CirculoConfianza> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<CirculoConfianza> buscarPorId(Integer idCirculo) {
        return repository.findById(idCirculo);
    }

    @Override
    public CirculoConfianza actualizar(Integer idCirculo,CirculoConfianza circulo) {
        circulo.setIdCirculo(idCirculo);
        return repository.save(circulo);
    }

    @Override
    public void eliminar(Integer idCirculo) {
        repository.deleteById(idCirculo);
    }
}