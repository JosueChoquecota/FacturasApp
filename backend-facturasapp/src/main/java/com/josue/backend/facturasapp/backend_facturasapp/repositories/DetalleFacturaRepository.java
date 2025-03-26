package com.josue.backend.facturasapp.backend_facturasapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Detalle_Facturas;

public interface DetalleFacturaRepository extends CrudRepository<Detalle_Facturas, Integer>{

}
