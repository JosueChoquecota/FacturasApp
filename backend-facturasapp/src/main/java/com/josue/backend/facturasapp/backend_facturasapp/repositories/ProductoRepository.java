package com.josue.backend.facturasapp.backend_facturasapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Productos;

public interface ProductoRepository extends CrudRepository<Productos, Integer> {

}
