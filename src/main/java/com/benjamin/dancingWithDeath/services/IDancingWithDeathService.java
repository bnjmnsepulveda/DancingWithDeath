package com.benjamin.dancingWithDeath.services;

import com.benjamin.dancingWithDeath.model.Cita;

/**
 *
 * @author benjamin
 */
public interface IDancingWithDeathService {
    Cita appointmentHour(Cita cita);   
    java.util.List<Cita> findCitas();
}
