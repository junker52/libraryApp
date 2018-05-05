package com.libreria.app.repository;

import com.libreria.app.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by HP on 12/04/2018.
 */
@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
     Libro findByTitulo(String titulo);
}
