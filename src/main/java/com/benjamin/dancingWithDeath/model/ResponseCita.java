package com.benjamin.dancingWithDeath.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author benjamin
 */
@Getter
@Setter
@ToString
public class ResponseCita {
    private Cita cita;
    private String estado;
    private String mensaje;
}