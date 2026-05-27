package com.examen.backend.service;

import com.examen.backend.model.Item;
import com.examen.backend.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> listar() {
        return repository.findAll();
    }

    public Item guardar(Item item) {
        return repository.save(item);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}