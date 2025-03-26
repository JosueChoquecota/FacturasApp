package com.josue.backend.facturasapp.backend_facturasapp.services;

import java.util.List;
import java.util.Optional;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Usuarios;

public interface UsuarioService {

    List<Usuarios> findAll();
    Optional<Usuarios> findById(Integer id);
    void deleteById(Integer id);
    Usuarios save(Usuarios usuarios);
    Usuarios update(Integer id, Usuarios usuarios);
    
}
