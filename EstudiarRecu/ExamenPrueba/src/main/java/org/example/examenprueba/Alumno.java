package org.example.examenprueba;

import com.mysql.cj.conf.PropertyDefinitions;

import java.sql.Date;

public class Alumno {
    private int id;
    private String nombre;
    private Date fecha_nacimiento;
    private int sexo;
    private int id_curso;
    private double nota_media;
    private double notaFinal;
    private String nombreCurso;

    public Alumno(String nombre,String nombreCurso, double nota_media, double notaFinal) {
        this.nombre = nombre;
        this.nombreCurso = nombreCurso;
        this.nota_media = nota_media;
        this.notaFinal = notaFinal;

    }

    public Alumno() {
    }

    public Alumno(String nombre, Date fecha_nacimiento, int sexo, int id_curso, double nota_media) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.id_curso = id_curso;
        this.nota_media = nota_media;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public double getNota_media() {
        return nota_media;
    }

    public void setNota_media(double nota_media) {
        this.nota_media = nota_media;
    }
}
