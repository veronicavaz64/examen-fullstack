package com.examen.backend.controller;

import com.examen.backend.model.Empleado;
import com.examen.backend.service.EmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Empleado> listar() {
        return service.listar();
    }

    @GetMapping("/activos")
    public List<Empleado> listarActivos() {
        return service.listarActivos();
    }

    @PostMapping
    public Empleado guardar(@RequestBody Empleado empleado) {
        return service.guardar(empleado);
    }

    @PutMapping("/{id}")
    public Empleado actualizar(@PathVariable Long id, @RequestBody Empleado empleado) {
        return service.actualizar(id, empleado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}