package com.libreria.app.dto;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 13/05/2018.
 */
public class ValidationReservaDTO  implements Serializable{

    private Boolean isValid = Boolean.FALSE;
    private List<String> errorMessages = new ArrayList<String>();
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
