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

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Productos;
import com.josue.backend.facturasapp.backend_facturasapp.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
 @Autowired
    private ProductoService service;

    @GetMapping
    public List<Productos> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Productos> listId(@PathVariable Integer id) {
        return service.findById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok("Cliente con ID" + id + "eliminado exitosamente.");
    }
    @PostMapping
    public ResponseEntity<Productos> create(@RequestBody Productos producto) {
        Productos nuevoProducto = service.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Productos producto) {
        try {
            Productos productoActualizado = service.update(id, producto);
            return ResponseEntity.ok(productoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
