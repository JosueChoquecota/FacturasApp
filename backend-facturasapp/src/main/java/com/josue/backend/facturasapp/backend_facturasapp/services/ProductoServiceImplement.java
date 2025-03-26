package com.josue.backend.facturasapp.backend_facturasapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.josue.backend.facturasapp.backend_facturasapp.models.entities.Productos;
import com.josue.backend.facturasapp.backend_facturasapp.repositories.ProductoRepository;

@Service
public class ProductoServiceImplement implements ProductoService {

    @Autowired
    private ProductoRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Productos> findAll() {
        return (List<Productos>) repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Productos> findById(Integer id) {
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
    public Productos save(Productos producto) {
        return repository.save(producto);
    }

@Override
    public Productos update(Integer id, Productos producto) {
        Optional<Productos> productoExistente = repository.findById(id);

        if (productoExistente.isPresent()) {
            Productos pro = productoExistente.get();
            pro.setCodigo_producto(producto.getCodigo_producto());
            pro.setNombre(producto.getNombre());
            pro.setDescripcion(producto.getDescripcion());
            pro.setPrecio(producto.getPrecio());
            pro.setStock(producto.getStock());
            pro.setFecha_registro(producto.getFecha_registro());
         
            
            return repository.save(pro);
        } else{
            throw new RuntimeException("Error: Cliente con ID\" + id + \" no encontrado");
        }
    }
    
}
