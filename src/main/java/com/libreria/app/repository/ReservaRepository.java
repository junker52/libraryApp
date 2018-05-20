package com.libreria.app.repository;

import com.libreria.app.model.Reserva;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by HP on 06/05/2018.
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

    @Query("select r from Reserva r where r.user.id = ?2 and r.fechaDesde <= ?1 and r.fechaHasta > ?1")
    List<Reserva> findReservaActivaByUsuario(Date fecha, Integer id_usuario);
}
