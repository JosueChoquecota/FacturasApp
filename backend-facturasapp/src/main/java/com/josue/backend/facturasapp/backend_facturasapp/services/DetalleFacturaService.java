package com.josue.backend.facturasapp.backend_facturasapp.services;

import java.util.List;
import java.util.Optional;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Detalle_Facturas;

public interface DetalleFacturaService  {   
    List<Detalle_Facturas> findAll();
    Optional<Detalle_Facturas> findById(Integer id);
    void deleteById(Integer id);
    Detalle_Facturas save(Detalle_Facturas detalle);
    Detalle_Facturas update(Integer id, Detalle_Facturas detalle);
}
