package org.example.ejercicio6tableview;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private int edad;
    private String genero;
    private String localidad;
    private LocalDate fecha;

    public Persona(String nombre, int edad, String genero, String localidad, LocalDate fecha) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.localidad = localidad;
        this.fecha = fecha;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getGenero() { return genero; }
    public String getLocalidad() { return localidad; }
    public LocalDate getFecha() { return fecha; }
}
