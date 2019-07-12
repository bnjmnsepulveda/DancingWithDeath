package com.benjamin.dancingWithDeath.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author benjamin
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cita {
    
    private Date date;
    private Date startTime;
    private String email;

    public Cita(Date date) {
        this.date = date;
    }

    public Cita(Date date, String email) {
        this.date = date;
        this.email = email;
    }
    
}
