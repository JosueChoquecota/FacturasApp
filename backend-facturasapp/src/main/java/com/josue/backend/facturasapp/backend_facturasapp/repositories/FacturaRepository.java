package com.josue.backend.facturasapp.backend_facturasapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Facturas;

public interface FacturaRepository extends CrudRepository<Facturas, Integer>{

}
