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

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Detalle_Facturas;
import com.josue.backend.facturasapp.backend_facturasapp.services.DetalleFacturaService;

@RestController
@RequestMapping("/api/detalles")
public class DetalleFacturaController {
 @Autowired
    private DetalleFacturaService service;

    @GetMapping
    public List<Detalle_Facturas> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Detalle_Facturas> listId(@PathVariable Integer id) {
        return service.findById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok("Detalle con ID" + id + "eliminado exitosamente.");
    }
    @PostMapping
    public ResponseEntity<Detalle_Facturas> create(@RequestBody Detalle_Facturas detalle) {
        Detalle_Facturas nuevoDetalle = service.save(detalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDetalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Detalle_Facturas detalle) {
        try {
            Detalle_Facturas DetalleActualizado = service.update(id, detalle);
            return ResponseEntity.ok(DetalleActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
