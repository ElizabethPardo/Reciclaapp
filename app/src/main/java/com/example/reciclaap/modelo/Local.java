package com.example.reciclaap.modelo;

import java.io.Serializable;

public class Local implements Serializable {

    private int id;
    private String cuilCuil;
    private String nombre;
    private String telefono;
    private String direccion;
    private String horarios;
    private String rubro;
    private boolean estado;
    private String foto;

    public Local(int id, String cuilCuil, String nombre, String telefono, String direccion, String horarios, String rubro, boolean estado, String foto) {
        this.id = id;
        this.cuilCuil = cuilCuil;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.horarios = horarios;
        this.rubro = rubro;
        this.estado = estado;
        this.foto = foto;
    }

    public Local() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuilCuil() {
        return cuilCuil;
    }

    public void setCuilCuil(String cuilCuil) {
        this.cuilCuil = cuilCuil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
