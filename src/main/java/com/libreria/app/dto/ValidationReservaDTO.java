package com.libreria.app.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by HP on 13/05/2018.
 */
public class ValidationReservaDTO  implements Serializable{

    private Boolean isValid = Boolean.FALSE;
    private List<String> errorMessages = new ArrayList<String>();

    @NotNull(message = "La fecha de fin no puede estar vacía")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaHasta;

    @NotNull(message = "La fecha de inicio no puede estar vacía")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaDesde;

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    @Override
    public String toString() {
        return "ValidationReservaDTO{" +
                "fechaHasta='" + fechaHasta + '\'' +
                ", fechaDesde='" + fechaDesde + '\'' +
                '}';
    }
}
