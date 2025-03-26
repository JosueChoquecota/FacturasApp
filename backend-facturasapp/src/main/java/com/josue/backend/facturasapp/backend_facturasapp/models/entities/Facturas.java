package com.josue.backend.facturasapp.backend_facturasapp.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Facturas")
public class Facturas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_factura")
    private Integer id_factura;
    @Column(name="codigo_factura")
    private String codigo_factura;
    @Column(name="id_cliente")
    private Integer id_cliente;
    @Column(name="id_usuario")
    private Integer id_usuario;
    @Column(name="fecha_emision", updatable = false, insertable = false)
    private LocalDate fecha_emision;
    @Column(name="total")
    private double total;
    @Column(name="estado")
    private String estado;
    public Integer getId_factura() {
        return id_factura;
    }
    public void setId_factura(Integer id_factura) {
        this.id_factura = id_factura;
    }
    public String getCodigo_factura() {
        return codigo_factura;
    }
    public void setCodigo_factura(String codigo_factura) {
        this.codigo_factura = codigo_factura;
    }
    public Integer getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }
    public Integer getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    public LocalDate getFecha_emision() {
        return fecha_emision;
    }
    public void setFecha_emision(LocalDate fecha_emision) {
        this.fecha_emision = fecha_emision;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
