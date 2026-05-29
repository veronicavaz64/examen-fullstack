package com.examen.backend.controller;

import com.examen.backend.model.Asistencia;
import com.examen.backend.service.AsistenciaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
@CrossOrigin(origins = "*")
public class AsistenciaController {

    private final AsistenciaService service;

    public AsistenciaController(AsistenciaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Asistencia> listar() {
        return service.listar();
    }

    @GetMapping("/fecha/{fecha}")
    public List<Asistencia> buscarPorFecha(@PathVariable String fecha) {
        return service.buscarPorFecha(fecha);
    }

    @PostMapping
    public Asistencia guardar(@RequestBody Asistencia asistencia) {
        return service.guardar(asistencia);
    }

    @PutMapping("/{id}")
    public Asistencia actualizar(@PathVariable Long id, @RequestBody Asistencia asistencia) {
        return service.actualizar(id, asistencia);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}