package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.MiembroCirculo;
import com.empresa.repository.MiembroCirculoRepository;

@Service
public class MiembroCirculoServiceImpl
        implements MiembroCirculoService {

    @Autowired
    private MiembroCirculoRepository repository;

    @Override
    public MiembroCirculo registrar(
            MiembroCirculo miembro) {

        return repository.save(miembro);
    }

    @Override
    public List<MiembroCirculo> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<MiembroCirculo> buscarPorId(Integer idMiembroCirculo) {
        return repository.findById(idMiembroCirculo);
    }

    @Override
    public List<MiembroCirculo> listaMiembrosPorCirculo(Integer idCirculo) {
         return repository.listaMiembrosPorCirculo(idCirculo);
    }

    @Override
    public void eliminar(Integer idMiembroCirculo) {
        repository.deleteById(idMiembroCirculo);
    }
}