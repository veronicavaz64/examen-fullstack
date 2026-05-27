package com.examen.backend.controller;

import com.examen.backend.model.Item;
import com.examen.backend.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<Item> listar() {
        return service.listar();
    }

    @PostMapping
    public Item guardar(@RequestBody Item item) {
        return service.guardar(item);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}