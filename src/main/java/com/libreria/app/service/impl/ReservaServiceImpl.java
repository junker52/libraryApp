package com.libreria.app.service.impl;

import com.libreria.app.configuration.LibrarySessionContext;
import com.libreria.app.dto.ValidationReservaDTO;
import com.libreria.app.model.Reserva;
import com.libreria.app.repository.ReservaRepository;
import com.libreria.app.repository.UserRepository;
import com.libreria.app.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private Validator validator;


    @Override
    @Transactional
    public void createReserva(Reserva reserva) {
        reserva.setUser(this.userRepository.getOne(this.librarySessionContext.getUsuario().getId()));
        this.reservaRepository.save(reserva);
    }

    @Override
    public void validateReserva(ValidationReservaDTO validationReservaDTO){
        List<String> validationErrorMessages = new ArrayList<>();
        this.propertiesValidation(validationReservaDTO, validationErrorMessages);
        validationReservaDTO.setErrorMessages(validationErrorMessages);
    }

    /**
     * Validación de java bean validator sobre el DTO
     * @param validationReservaDTO
     * @param validationErrorMessages
     *
     */
    private void propertiesValidation(ValidationReservaDTO validationReservaDTO, List<String> validationErrorMessages ){
        Set<ConstraintViolation<ValidationReservaDTO>> violations = validator.validate(validationReservaDTO);
        for (ConstraintViolation<ValidationReservaDTO> violation : violations) {
            validationErrorMessages.add(violation.getMessage());
        }
        if (violations.isEmpty()){
            validationReservaDTO.setValid(Boolean.TRUE);
        }
    }

}
