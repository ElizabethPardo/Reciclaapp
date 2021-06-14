package com.example.reciclaap.modelo;

import java.util.Date;

public class DaPuntos {

    private int id;
    private Date fecha;
    private int puntos;
    private String descripcion;
    private Usuario usuario;
    private Local local;

    public DaPuntos(int id, Date fecha, int puntos, String descripcion, Usuario usuario, Local local) {
        this.id = id;
        this.fecha = fecha;
        this.puntos = puntos;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.local = local;
    }

    public DaPuntos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
