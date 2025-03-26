package com.josue.backend.facturasapp.backend_facturasapp.services;

import java.util.List;
import java.util.Optional;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Productos;

public interface ProductoService {
    List<Productos> findAll();
    Optional<Productos> findById(Integer id);
    void deleteById(Integer id);
    Productos save(Productos productos);
    Productos update(Integer id, Productos productos);
}
