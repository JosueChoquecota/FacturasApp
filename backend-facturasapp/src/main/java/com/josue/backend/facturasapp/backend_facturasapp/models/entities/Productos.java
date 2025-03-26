package com.josue.backend.facturasapp.backend_facturasapp.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Productos")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer id_producto;
    @Column(name="codigo_producto")
    private String codigo_producto;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="precio")
    private double precio;
    @Column(name="stock")
    private Integer stock;
    @Column(name="fecha_registro", updatable=false, insertable=false)
    private LocalDate fecha_registro;
    public Integer getId_producto() {
        return id_producto;
    }
    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }
    public String getCodigo_producto() {
        return codigo_producto;
    }
    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public LocalDate getFecha_registro() {
        return fecha_registro;
    }
    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    

}
