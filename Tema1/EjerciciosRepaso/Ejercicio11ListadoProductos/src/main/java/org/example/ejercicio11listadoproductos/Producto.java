package org.example.ejercicio11listadoproductos;

public class Producto {
    private String nombre;
    private Integer unidades;
    private Double precio;

    public Producto() {
    }

    public Producto(String nombre, Integer unidades, Double precio) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    // Campo calculado
    public Double getSubtotal() {
        return unidades * precio;
    }
}
