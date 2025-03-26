package com.josue.backend.facturasapp.backend_facturasapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Usuarios;

public interface UsuarioReporitory extends CrudRepository<Usuarios, Integer>{
    Optional<Usuarios> findByCorreo(String correo);
}
