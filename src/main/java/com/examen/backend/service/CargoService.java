package com.examen.backend.service;

import com.examen.backend.model.Cargo;
import com.examen.backend.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    private final CargoRepository repository;

    public CargoService(CargoRepository repository) {
        this.repository = repository;
    }

    public List<Cargo> listar() {
        return repository.findAll();
    }

    public Cargo guardar(Cargo cargo) {
        return repository.save(cargo);
    }

    public Cargo actualizar(Long id, Cargo cargo) {
        Cargo existente = repository.findById(id).orElseThrow();
        existente.setNombre(cargo.getNombre());
        existente.setSalarioBase(cargo.getSalarioBase());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}