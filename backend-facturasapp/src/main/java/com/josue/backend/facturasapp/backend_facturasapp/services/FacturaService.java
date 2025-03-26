package com.josue.backend.facturasapp.backend_facturasapp.services;

import java.util.List;
import java.util.Optional;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Facturas;

public interface FacturaService {

    List<Facturas> findAll();
    Optional<Facturas> findById(Integer id);
    void deleteById(Integer id);
    Facturas save(Facturas facturas);
    Facturas update(Integer id, Facturas facturas);
}
