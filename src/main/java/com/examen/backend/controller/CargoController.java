package com.examen.backend.controller;

import com.examen.backend.model.Cargo;
import com.examen.backend.service.CargoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
@CrossOrigin(origins = "*")
public class CargoController {

    private final CargoService service;

    public CargoController(CargoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cargo> listar() {
        return service.listar();
    }

    @PostMapping
    public Cargo guardar(@RequestBody Cargo cargo) {
        return service.guardar(cargo);
    }

    @PutMapping("/{id}")
    public Cargo actualizar(@PathVariable Long id, @RequestBody Cargo cargo) {
        return service.actualizar(id, cargo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}