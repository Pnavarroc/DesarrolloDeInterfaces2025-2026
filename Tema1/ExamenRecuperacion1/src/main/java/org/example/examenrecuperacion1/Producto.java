package org.example.examenrecuperacion1;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int categoria;
    private int marca;
    private int wifi;
    private int bluetooth;
    private int nfc;
    private int g5;
    private int estado;
    private String nombreCategoria;
    private String nombreMarca;
    private Double precioIVA;

    public Producto(String nombre, double precio,Double precioIVA, String nombreCategoria, String nombreMarca, int estado) {
        this.nombre = nombre;
        this.precio = precio;
        this.precioIVA = precioIVA;
        this.nombreCategoria = nombreCategoria;
        this.nombreMarca = nombreMarca;
        this.estado = estado;
    }

    public Producto() {
    }

    public Producto(int id, String nombre, double precio, int categoria, int marca, int wifi, int bluetooth, int nfc, int g5, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.marca = marca;
        this.wifi = wifi;
        this.bluetooth = bluetooth;
        this.nfc = nfc;
        this.g5 = g5;
        this.estado = estado;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public Double getPrecioIVA() {
        return precioIVA;
    }

    public void setPrecioIVA(Double precioIVA) {
        this.precioIVA = precioIVA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public int getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(int bluetooth) {
        this.bluetooth = bluetooth;
    }

    public int getNfc() {
        return nfc;
    }

    public void setNfc(int nfc) {
        this.nfc = nfc;
    }

    public int getG5() {
        return g5;
    }

    public void setG5(int g5) {
        this.g5 = g5;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                ", marca=" + marca +
                ", wifi=" + wifi +
                ", bluetooth=" + bluetooth +
                ", nfc=" + nfc +
                ", g5=" + g5 +
                ", estado=" + estado +
                '}';
    }
}
