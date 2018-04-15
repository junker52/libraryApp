package com.libreria.app.repository;

import com.libreria.app.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by HP on 12/04/2018.
 */
@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

    Autor findAutorByNombreContains(String nombre);
}
