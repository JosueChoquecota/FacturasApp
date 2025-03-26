package com.josue.backend.facturasapp.backend_facturasapp.repositories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Usuarios;
import com.josue.backend.facturasapp.backend_facturasapp.services.UsuarioService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UsuarioService service;

    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuarios usuario) {
        Usuarios nuevoUsuario = service.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

}
