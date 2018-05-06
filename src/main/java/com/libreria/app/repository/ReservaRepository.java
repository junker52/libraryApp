package com.libreria.app.repository;

import com.libreria.app.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by HP on 06/05/2018.
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
}
