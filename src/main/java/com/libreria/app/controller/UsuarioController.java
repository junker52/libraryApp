package com.libreria.app.controller;

import com.libreria.app.configuration.LibrarySessionContext;
import com.libreria.app.dto.LibraryBaseModel;
import com.libreria.app.globals.PageNameGlobals;
import com.libreria.app.model.Reserva;
import com.libreria.app.service.ReservaService;
import com.libreria.app.service.impl.ReservaServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * Created by HP on 19/05/2018.
 */

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private LibrarySessionContext sessionContext;

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String MIS_ALQUILERES = "misalquileres";

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/misalquileres")
    private LibraryBaseModel getMisAlquileresPage(){
        LibraryBaseModel lbm = new LibraryBaseModel(MIS_ALQUILERES, MIS_ALQUILERES);
        List<Reserva> reservas = this.reservaService.getAllValidReservasByUsuario(this.sessionContext.getUsuario().getId());
        lbm.addObject("sessionContext",sessionContext);
        lbm.addObject("reservas",reservas);
        return lbm;
    }

    @GetMapping("/devolver/{id_reserva}")
    private RedirectView devolverReserva(@PathVariable("id_reserva") Integer idReserva){
        //TODO Implementar devolver libro modificando la fechaHasta de la reserva
        return null;
    }

    @GetMapping("/devolver/{id_reserva}")
    private RedirectView prorrogarReserva(@PathVariable("id_reserva") Integer idReserva){
        //TODO Implementar prorrogar reserva 10 dias
        return null;
    }
}
