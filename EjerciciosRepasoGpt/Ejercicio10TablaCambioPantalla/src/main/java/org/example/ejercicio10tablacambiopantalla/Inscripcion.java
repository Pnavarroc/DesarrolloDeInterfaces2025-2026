package org.example.ejercicio10tablacambiopantalla;


public class Inscripcion {

    private String nombre;
    private String ciudad;
    private String modulos;

    public Inscripcion(String nombre, String ciudad, String modulos) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.modulos = modulos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getModulos() {
        return modulos;
    }
}
