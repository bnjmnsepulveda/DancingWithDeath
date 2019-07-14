package com.benjamin.dancingWithDeath.services;

import com.benjamin.dancingWithDeath.model.Cita;
import java.util.Date;

/**
 *
 * @author benjamin
 */
public interface IAgendaService {

    public boolean validateInfo(Cita cita);

    public boolean isHourTaken(Date date);

    public boolean isHourTaken(String contacto);

    public void addCita(Cita cita);

    public int citasSize();

    public boolean isOfficeHour(Date date);
}
