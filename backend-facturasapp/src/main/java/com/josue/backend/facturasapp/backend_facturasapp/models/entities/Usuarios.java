package com.josue.backend.facturasapp.backend_facturasapp.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario", updatable = false, nullable = false)
    private Integer id_usuario;
    @Column(name="cod_usuario")
    private String cod_usuario;
    @Column(name="nombre")
    private String nombre;
    @Column(name="correo")
    private String correo;
    @Column(name="contraseña")
    private String contraseña;
    @Column(name="fecha_registro", updatable = false, insertable = false)
    private LocalDate fecha_registro;
    public Integer getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getCod_usuario() {
        return cod_usuario;
    }
    public void setCod_usuario(String cod_usuario) {
        this.cod_usuario = cod_usuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public LocalDate getFecha_registro() {
        return fecha_registro;
    }
    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
}
