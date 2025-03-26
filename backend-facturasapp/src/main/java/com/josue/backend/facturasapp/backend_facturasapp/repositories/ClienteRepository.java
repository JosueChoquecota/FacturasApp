package com.josue.backend.facturasapp.backend_facturasapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Clientes;

public interface ClienteRepository extends CrudRepository<Clientes, Integer> {

}
