package org.example.ejercicio12mostrarregistrosnuevaventana;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private int paginas;
    private int genero;
    private int disponible;

    public Libro(int id, String titulo, String autor, String isbn, int paginas, int genero, int disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.paginas = paginas;
        this.genero = genero;
        this.disponible = disponible;
    }

    // Getters

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public int getPaginas() { return paginas; }
    public int getGenero() { return genero; }
    public int getDisponible() { return disponible; }
}

