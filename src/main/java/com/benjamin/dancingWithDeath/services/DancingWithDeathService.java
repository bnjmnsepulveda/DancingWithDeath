package com.benjamin.dancingWithDeath.services;

import com.benjamin.dancingWithDeath.model.Cita;
import com.benjamin.dancingWithDeath.utils.HourTakenException;
import com.benjamin.dancingWithDeath.utils.NotOfficeHourException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author benjamin
 */
@Service
public class DancingWithDeathService implements IDancingWithDeathService{

    @Autowired
    private IAgendaService service;
    
    @Override
    public Cita appointmentHour(Cita cita) {
        if(!service.validateInfo(cita)){
            throw new IllegalArgumentException("info de cita " + cita + " no es valido");
        }
        if(!service.isOfficeHour(cita.getDate())){
            throw new NotOfficeHourException("hour " + cita.getDate() + " not office hour");
        }
        if(service.isHourTaken(cita.getDate())){
            throw new HourTakenException("Hour " + cita.getDate() + " is taken");
        }
        if(service.isHourTaken(cita.getEmail())){
            throw new HourTakenException("Hour " + cita.getDate() + " is taken");
        }
        service.addCita(cita);
        return cita;
    }

    @Override
    public List<Cita> findCitas() {
        return service.findCitas();
    }
    
}
