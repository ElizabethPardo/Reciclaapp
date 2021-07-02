package com.example.reciclaap.modelo;
import java.io.Serializable;
import java.util.Date;

public class Canje implements Serializable {

    private int id;
    private Date fecha;
    private String descripcion;
    private int cant;
    private Usuario usuario;
    private Producto producto;

    public Canje(int id, Date fecha, String descripcion, int cant, Usuario usuario, Producto producto) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.cant = cant;
        this.usuario = usuario;
        this.producto = producto;
    }

    public Canje() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}