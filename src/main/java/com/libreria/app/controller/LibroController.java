package com.libreria.app.controller;

import com.libreria.app.configuration.LibrarySessionContext;
import com.libreria.app.dto.LibraryBaseModel;
import com.libreria.app.model.Libro;
import com.libreria.app.model.Reserva;
import com.libreria.app.service.LibroService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by HP on 24/04/2018.
 */
@Controller
public class LibroController {

    @Autowired
    private LibrarySessionContext sessionContext;

    @Autowired
    private LibroService libroService;

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("libro/{id}/reserva")
    private LibraryBaseModel showReservaModal(@PathVariable("id") String id_libro){
        logger.info("Showing reservation modal for libro "+id_libro);
        Reserva reserva = new Reserva();
        reserva.setLibro(this.getLibroById(id_libro));
        reserva.setUser(this.sessionContext.getUsuario());
        LibraryBaseModel lbm = new LibraryBaseModel("fragments/templates :: modal", "titulo");
        lbm.addObject("reserva", reserva);
        return lbm;
    }

    private Libro getLibroById(String id){
        Integer idLibro = Integer.parseInt(id);
        return this.libroService.findLibroById(idLibro);
    }
}
