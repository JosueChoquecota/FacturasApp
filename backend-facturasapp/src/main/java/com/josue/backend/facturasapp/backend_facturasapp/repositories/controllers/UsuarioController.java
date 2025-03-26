package com.josue.backend.facturasapp.backend_facturasapp.repositories.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Usuarios;
import com.josue.backend.facturasapp.backend_facturasapp.services.UsuarioService;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;
    
    @GetMapping
    public List<Usuarios> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuarios> listId(@PathVariable Integer id) {
        return service.findById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok("Cliente con ID" + id + "eliminado exitosamente.");
    }
    @PostMapping
    public ResponseEntity<Usuarios> create(@RequestBody Usuarios usuarios) {
        Usuarios nuevoUsuario = service.save(usuarios);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Usuarios usuarios) {
        try {
            Usuarios usuarioActualizado = service.update(id, usuarios);
            return ResponseEntity.ok(usuarioActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
