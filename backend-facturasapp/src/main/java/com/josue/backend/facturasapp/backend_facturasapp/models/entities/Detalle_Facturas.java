package com.josue.backend.facturasapp.backend_facturasapp.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Detalle_Facturas")
public class Detalle_Facturas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle", updatable = false, nullable = false)
    private Integer id_detalle;
    @Column(name = "id_factura")
    private Integer id_factura;
    @Column(name = "id_producto")
    private Integer id_producto;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio_unitario")
    private double  precio_unitario;
    @Column(name = "subtotal")
    private double  subtotal;
    public Integer getId_detalle() {
        return id_detalle;
    }
    public void setId_detalle(Integer id_detalle) {
        this.id_detalle = id_detalle;
    }
    public Integer getId_factura() {
        return id_factura;
    }
    public void setId_factura(Integer id_factura) {
        this.id_factura = id_factura;
    }
    public Integer getId_producto() {
        return id_producto;
    }
    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public double getPrecio_unitario() {
        return precio_unitario;
    }
    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}

