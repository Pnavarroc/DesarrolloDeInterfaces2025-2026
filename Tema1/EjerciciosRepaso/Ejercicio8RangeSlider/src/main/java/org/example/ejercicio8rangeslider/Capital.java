package org.example.ejercicio8rangeslider;

public class Capital {
    private String provincia;
    private String autonomia;
    private Integer poblacion;

    public Capital() {
    }

    public Capital(String provincia, String autonomia, Integer poblacion) {
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

    public Integer getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Capital{" +
                "provincia='" + provincia + '\'' +
                ", autonomia='" + autonomia + '\'' +
                ", poblacion=" + poblacion +
                '}';
    }
}
