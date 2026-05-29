package com.examen.backend.service;

import com.examen.backend.model.Usuario;
import com.examen.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario registrar(Usuario usuario) {
        if (usuario.getRol() == null || usuario.getRol().isBlank()) {
            usuario.setRol("ADMIN");
        }

        return repository.save(usuario);
    }

    public Usuario login(Usuario usuario) {
        return repository.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword())
                .orElseThrow(() -> new RuntimeException("Usuario o contraseña incorrectos"));
    }
}