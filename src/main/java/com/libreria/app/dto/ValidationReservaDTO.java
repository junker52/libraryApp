package com.libreria.app.dto;

import java.io.Serializable;

/**
 * Created by HP on 13/05/2018.
 */
public class ValidationReservaDTO  implements Serializable{

    private String fechaHasta;
    private String fechaDesde;

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    @Override
    public String toString() {
        return "ValidationReservaDTO{" +
                "fechaHasta='" + fechaHasta + '\'' +
                ", fechaDesde='" + fechaDesde + '\'' +
                '}';
    }
}
