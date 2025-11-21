package org.example.examenpablonavarrocamacho;

import java.util.Date;

public class Empleado {
    private Integer id;
    private String nombre;
    private Date fechaNacimiento;
    private Integer sexo;
    private Integer departamento;
    private Double salario;


    public Empleado() {
    }

    public Empleado(Integer id, String nombre, Date fechaNacimiento, Integer sexo, Integer departamento, Double salario) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.departamento = departamento;
        this.salario = salario;
    }

    public Empleado(String nombre, Integer departamento, Double salario) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Integer getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Integer departamento) {
        this.departamento = departamento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double get15Salario(){
        return salario-(salario*(0.15));
    }
}
