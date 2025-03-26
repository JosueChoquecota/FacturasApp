package com.josue.backend.facturasapp.backend_facturasapp.services;

import java.util.List;
import java.util.Optional;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Clientes;

public interface ClienteService {

    List<Clientes> findAll();
    Optional<Clientes> findById(Integer id);
    void deleteById(Integer id);
    Clientes save(Clientes cliente);
    Clientes update(Integer id, Clientes cliente);
}
