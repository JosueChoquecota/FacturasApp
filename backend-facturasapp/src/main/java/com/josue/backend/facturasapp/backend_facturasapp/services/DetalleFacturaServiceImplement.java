package com.josue.backend.facturasapp.backend_facturasapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Detalle_Facturas;
import com.josue.backend.facturasapp.backend_facturasapp.repositories.DetalleFacturaRepository;

@Service
public class DetalleFacturaServiceImplement implements DetalleFacturaService{


    @Autowired
    private DetalleFacturaRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Detalle_Facturas> findAll() {
        return (List<Detalle_Facturas>) repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Detalle_Facturas> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Error: Detalle con ID\" + id + \"no encontrado");
        }
    }

    @Override
    public Detalle_Facturas save(Detalle_Facturas detalle) {

        return repository.save(detalle);
    }
    
    @Override
    public Detalle_Facturas update(Integer id, Detalle_Facturas detalle) {
        Optional<Detalle_Facturas> detalleExistente = repository.findById(id);

        if (detalleExistente.isPresent()) {
            Detalle_Facturas det = detalleExistente.get();

            det.setId_factura(detalle.getId_factura());
            det.setId_producto(detalle.getId_producto());
            det.setCantidad(detalle.getCantidad());
            det.setPrecio_unitario(detalle.getPrecio_unitario());
            det.setSubtotal(detalle.getSubtotal());        
            return repository.save(det);
        } else{
            throw new RuntimeException("Error: Detalle con ID\" + id + \" no encontrado");
        }
    }

}
