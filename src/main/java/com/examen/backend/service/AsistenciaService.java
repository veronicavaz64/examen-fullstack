package com.examen.backend.service;

import com.examen.backend.model.Asistencia;
import com.examen.backend.repository.AsistenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaService {

    private final AsistenciaRepository repository;

    public AsistenciaService(AsistenciaRepository repository) {
        this.repository = repository;
    }

    public List<Asistencia> listar() {
        return repository.findAll();
    }

    public Asistencia guardar(Asistencia asistencia) {
        return repository.save(asistencia);
    }

    public Asistencia actualizar(Long id, Asistencia asistencia) {
        Asistencia existente = repository.findById(id).orElseThrow();

        existente.setFecha(asistencia.getFecha());
        existente.setHoraEntrada(asistencia.getHoraEntrada());
        existente.setHoraSalida(asistencia.getHoraSalida());
        existente.setObservacion(asistencia.getObservacion());
        existente.setEmpleado(asistencia.getEmpleado());

        return repository.save(existente);
    }

    public List<Asistencia> buscarPorFecha(String fecha) {
        return repository.findByFecha(fecha);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}