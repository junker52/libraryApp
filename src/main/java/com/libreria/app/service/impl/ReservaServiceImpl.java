package com.libreria.app.service.impl;

import com.libreria.app.configuration.LibrarySessionContext;
import com.libreria.app.dto.LibraryBaseModel;
import com.libreria.app.model.Reserva;
import com.libreria.app.repository.ReservaRepository;
import com.libreria.app.repository.UserRepository;
import com.libreria.app.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by HP on 06/05/2018.
 */
@Service
public class ReservaServiceImpl implements ReservaService {


    @Qualifier("reservaRepository")
    @Autowired
    private ReservaRepository reservaRepository;

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LibrarySessionContext librarySessionContext;


    @Override
    @Transactional
    public void createReserva(Reserva reserva) {
        reserva.setUser(this.userRepository.getOne(this.librarySessionContext.getUsuario().getId()));
        this.reservaRepository.save(reserva);
    }
}
