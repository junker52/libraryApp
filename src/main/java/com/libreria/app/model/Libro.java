package com.libreria.app.model;

import javax.persistence.*;

/**
 * Created by HP on 09/04/2018.
 */
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private String editorial;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    public Libro() {
    }

    public Libro(String titulo, String editorial, Autor autor) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
