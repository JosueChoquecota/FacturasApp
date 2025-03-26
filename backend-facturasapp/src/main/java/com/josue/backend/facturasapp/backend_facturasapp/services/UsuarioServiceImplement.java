package com.josue.backend.facturasapp.backend_facturasapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Usuarios;
import com.josue.backend.facturasapp.backend_facturasapp.repositories.UsuarioReporitory;

@Service
public class UsuarioServiceImplement implements UsuarioService{

    @Autowired
    private UsuarioReporitory repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> findAll() {
        return (List<Usuarios>) repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Usuarios> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Error: Producto con ID\" + id + \"no encontrado");
        }
    }

    @Override
    public Usuarios save(Usuarios usuarios) {
        String contraseñaEncriptada = passwordEncoder.encode(usuarios.getContraseña());
        usuarios.setContraseña(contraseñaEncriptada);
        return repository.save(usuarios); 
    }
    
    @Override
    public Usuarios update(Integer id, Usuarios usuarios) {
        Optional<Usuarios> usuarioExistente = repository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuarios usu = usuarioExistente.get();

            usu.setCod_usuario(usuarios.getCod_usuario());
            usu.setNombre(usuarios.getNombre());
            usu.setCorreo(usuarios.getNombre());
            usu.setContraseña(usuarios.getContraseña());
            usu.setFecha_registro(usuarios.getFecha_registro());
            
            return repository.save(usu);
        } else{
            throw new RuntimeException("Error: Usuario con ID\" + id + \" no encontrado");
        }
    }




}
