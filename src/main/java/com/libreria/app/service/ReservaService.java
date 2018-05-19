package com.libreria.app.service;

import com.libreria.app.dto.ValidationReservaDTO;
import com.libreria.app.model.Reserva;

/**
 * Created by HP on 06/05/2018.
 */
public interface ReservaService {
    void createReserva(Reserva reserva);
    void validateReserva(ValidationReservaDTO validationReservaDTO);
}
