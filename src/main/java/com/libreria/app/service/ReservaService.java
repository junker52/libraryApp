package com.libreria.app.service;

import com.libreria.app.dto.ValidationReservaDTO;
import com.libreria.app.model.Reserva;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by HP on 06/05/2018.
 */
public interface ReservaService {
    void createReserva(Reserva reserva);

    @Transactional
    void devolverReserva(Integer idReserva);

    void validateReserva(ValidationReservaDTO validationReservaDTO);

    List<Reserva> getAllValidReservasByUsuario(Integer id_usuario);

    Reserva getResevaById(Integer id);
}
