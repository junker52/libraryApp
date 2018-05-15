package com.libreria.app.controller;

import com.libreria.app.configuration.LibrarySessionContext;
import com.libreria.app.dto.LibraryBaseModel;
import com.libreria.app.dto.ValidationReservaDTO;
import com.libreria.app.model.Libro;
import com.libreria.app.model.Reserva;
import com.libreria.app.service.LibroService;
import com.libreria.app.service.ReservaService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.transaction.Transactional;

/**
 * Created by HP on 24/04/2018.
 */
@Controller
public class LibroController {

    @Autowired
    private LibrarySessionContext sessionContext;

    @Autowired
    private LibroService libroService;

    @Autowired
    private ReservaService reservaService;


    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("libro/{id}/reserva")
    private LibraryBaseModel showReservaModal(@PathVariable("id") String id_libro){
        logger.info("Showing reservation modal for libro "+id_libro);
        Reserva reserva = new Reserva();
        reserva = this.addLibroToReserva(reserva, id_libro);
        LibraryBaseModel lbm = new LibraryBaseModel("fragments/templates :: modal", "titulo");
        lbm.addObject("idLibro",id_libro);
        lbm.addObject("reserva", reserva);
        return lbm;
    }

    @PostMapping("crearReserva")
    private RedirectView createReserva(@RequestParam("id") String id, Reserva reserva, RedirectAttributes redirectAttributes){
        reserva = this.addLibroToReserva(reserva, id);
        this.reservaService.createReserva(reserva);
        redirectAttributes.addFlashAttribute("reservaSucces", "Reserva creada con exito");
        RedirectView redirectView = new RedirectView("/",false);
        return redirectView;
    }

    @PostMapping(value = "/validateReserva", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    private @ResponseBody ValidationReservaDTO validateReserva(@RequestBody ValidationReservaDTO validationReservaDTO){
        this.logger.info(validationReservaDTO.toString());
        return validationReservaDTO;
    }


    /**
     * Metodo para inyectar libro y usuario a la reserva
     * @param reserva
     * @param id_libro
     * @return
     */
    private Reserva addLibroToReserva(Reserva reserva, String id_libro){
        reserva.setLibro(this.getLibroById(id_libro));
        return reserva;
    }

    private Libro getLibroById(String id){
        Integer idLibro = Integer.parseInt(id);
        return this.libroService.findLibroById(idLibro);
    }
}
