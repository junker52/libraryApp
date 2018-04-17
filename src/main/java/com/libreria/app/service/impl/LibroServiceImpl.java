package com.libreria.app.service.impl;

import com.libreria.app.model.Libro;
import com.libreria.app.repository.LibroRepository;
import com.libreria.app.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HP on 17/04/2018.
 */
@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;


    @Override
    public List<Libro> findAllLibros() {
        return libroRepository.findAll();
    }
}
