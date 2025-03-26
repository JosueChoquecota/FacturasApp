package com.josue.backend.facturasapp.backend_facturasapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Clientes;
import com.josue.backend.facturasapp.backend_facturasapp.repositories.ClienteRepository;


@Service
public class ClienteServiceImplement implements ClienteService {

    @Autowired
    private ClienteRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Clientes> findAll() {
        return (List<Clientes>) repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Clientes> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Error: Cliente con ID\" + id + \"no encontrado");
        }
    }

    @Override
    public Clientes save(Clientes cliente) {

        return repository.save(cliente);
    }
    
    @Override
    public Clientes update(Integer id, Clientes cliente) {
        Optional<Clientes> clienteExistente = repository.findById(id);

        if (clienteExistente.isPresent()) {
            Clientes cli = clienteExistente.get();

            cli.setCodigoCliente(cliente.getCodigoCliente());
            cli.setNombre(cliente.getNombre());
            cli.setCorreo(cliente.getCorreo());
            cli.setTelefono(cliente.getTelefono());
            cli.setDireccion(cliente.getDireccion());
            cli.setFechaRegistro(cliente.getFechaRegistro());
            
            return repository.save(cli);
        } else{
            throw new RuntimeException("Error: Cliente con ID\" + id + \" no encontrado");
        }
    }
}
