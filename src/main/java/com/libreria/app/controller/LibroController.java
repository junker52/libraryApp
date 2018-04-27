package com.libreria.app.controller;

import com.libreria.app.configuration.LibrarySessionContext;
import com.libreria.app.dto.LibraryBaseModel;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by HP on 24/04/2018.
 */
@Controller
public class LibroController {

    @Autowired
    private LibrarySessionContext sessionContext;

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("libro/{id}/reserva")
    private LibraryBaseModel showReservaModal(@PathVariable("id") String id_libro){
        logger.info("Showing reservation modal for libro "+id_libro);
        LibraryBaseModel lbm = new LibraryBaseModel("fragments/templates :: modal", "titulo");
        return lbm;
    }
}
