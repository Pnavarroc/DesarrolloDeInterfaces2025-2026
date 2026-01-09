package org.example.formulariotablavalidacion;

public class Empleado {
    private String nombre;
    private String localidad;
    private double salario ;
    private String Departamento;

    public Empleado() {
    }

    public Empleado(String nombre, String localidad, double salario, String departamento) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.salario = salario;
        Departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }
}
