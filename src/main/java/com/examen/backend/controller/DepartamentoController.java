package com.examen.backend.controller;

import com.examen.backend.model.Departamento;
import com.examen.backend.service.DepartamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
@CrossOrigin(origins = "*")
public class DepartamentoController {

    private final DepartamentoService service;

    public DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Departamento> listar() {
        return service.listar();
    }

    @PostMapping
    public Departamento guardar(@RequestBody Departamento departamento) {
        return service.guardar(departamento);
    }

    @PutMapping("/{id}")
    public Departamento actualizar(@PathVariable Long id, @RequestBody Departamento departamento) {
        return service.actualizar(id, departamento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}