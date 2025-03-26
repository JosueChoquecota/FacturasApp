package com.josue.backend.facturasapp.backend_facturasapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Facturas;
import com.josue.backend.facturasapp.backend_facturasapp.repositories.FacturaRepository;

@Service
public class FacturaServiceImplement implements FacturaService {

    @Autowired
    private FacturaRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Facturas> findAll() {
        return (List<Facturas>) repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Facturas> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Error: Factura con ID\" + id + \"no encontrado");
        }
    }

    @Override
    public Facturas save(Facturas facturas) {

        return repository.save(facturas);
    }
    @Override
    public Facturas update(Integer id, Facturas facturas) {
        Optional<Facturas> facturaExistente = repository.findById(id);

        if (facturaExistente.isPresent()) {
            Facturas fac = facturaExistente.get();

            fac.setCodigo_factura(facturas.getCodigo_factura());
            fac.setId_cliente(facturas.getId_cliente());
            fac.setId_usuario(facturas.getId_usuario());
            fac.setFecha_emision(facturas.getFecha_emision());
            fac.setTotal(facturas.getTotal());
            fac.setEstado(facturas.getEstado());
            
            return repository.save(fac);
        } else{
            throw new RuntimeException("Error: Factura con ID\" + id + \" no encontrado");
        }
    }
}
