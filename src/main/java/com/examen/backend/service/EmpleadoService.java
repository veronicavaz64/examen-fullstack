package com.examen.backend.service;

import com.examen.backend.model.Empleado;
import com.examen.backend.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public List<Empleado> listar() {
        return repository.findAll();
    }

    public Empleado guardar(Empleado empleado) {
        if (empleado.getCedula() == null || empleado.getCedula().isBlank()) {
            throw new RuntimeException("La cédula es obligatoria");
        }

        if (empleado.getEstado() == null || empleado.getEstado().isBlank()) {
            empleado.setEstado("ACTIVO");
        }

        return repository.save(empleado);
    }

    public Empleado actualizar(Long id, Empleado empleado) {
        Empleado existente = repository.findById(id).orElseThrow();

        existente.setCedula(empleado.getCedula());
        existente.setNombre(empleado.getNombre());
        existente.setApellido(empleado.getApellido());
        existente.setCorreo(empleado.getCorreo());
        existente.setEstado(empleado.getEstado());
        existente.setDepartamento(empleado.getDepartamento());
        existente.setCargo(empleado.getCargo());

        return repository.save(existente);
    }

    public List<Empleado> listarActivos() {
        return repository.findByEstado("ACTIVO");
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}