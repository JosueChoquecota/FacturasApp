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

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Facturas;
import com.josue.backend.facturasapp.backend_facturasapp.services.FacturaService;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    @Autowired
    private FacturaService service;

    @GetMapping
    public List<Facturas> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Facturas> listId(@PathVariable Integer id) {
        return service.findById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok("Cliente con ID" + id + "eliminado exitosamente.");
    }
    @PostMapping
    public ResponseEntity<Facturas> create(@RequestBody Facturas facturas) {
        Facturas nuevoFacturas = service.save(facturas);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoFacturas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Facturas facturas) {
        try {
            Facturas facturaActualizado = service.update(id, facturas);
            return ResponseEntity.ok(facturaActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
