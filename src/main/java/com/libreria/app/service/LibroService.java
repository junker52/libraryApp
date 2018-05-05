package com.libreria.app.service;

import com.libreria.app.model.Libro;

import java.util.List;

/**
 * Created by HP on 17/04/2018.
 */
public interface LibroService {
    List<Libro> findAllLibros();
    Libro findLibroById(Integer id);
}
