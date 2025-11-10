package org.example.pruebajavafx;

public class Capitales {
    private String provincia;
    private String autonomia;
    private int poblacion;

    public Capitales() {
    }

    public Capitales(String provincia, String autonomia, int poblacion) {
        this.provincia = provincia;
        this.autonomia = autonomia;
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(String autonomia) {
        this.autonomia = autonomia;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Capitales{" +
                "provincia='" + provincia + '\'' +
                ", autonomia='" + autonomia + '\'' +
                ", poblacion=" + poblacion +
                '}';
    }
}
