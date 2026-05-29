package com.examen.backend.service;

import com.examen.backend.model.Departamento;
import com.examen.backend.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoRepository repository;

    public DepartamentoService(DepartamentoRepository repository) {
        this.repository = repository;
    }

    public List<Departamento> listar() {
        return repository.findAll();
    }

    public Departamento guardar(Departamento departamento) {
        return repository.save(departamento);
    }

    public Departamento actualizar(Long id, Departamento departamento) {
        Departamento existente = repository.findById(id).orElseThrow();
        existente.setNombre(departamento.getNombre());
        existente.setDescripcion(departamento.getDescripcion());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}