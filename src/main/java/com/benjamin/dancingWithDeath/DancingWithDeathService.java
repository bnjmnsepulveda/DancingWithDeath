package com.benjamin.dancingWithDeath;

import com.benjamin.dancingWithDeath.model.Cita;
import com.benjamin.dancingWithDeath.services.AgendaService;
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
public class DancingWithDeathService {

    @Autowired
    private AgendaService service;
    
    public void appointmentHour(Cita cita) {
        if(!service.validateInfo(cita)){
            throw new IllegalArgumentException("info de cita " + cita + " no es valido");
        }
        if(!service.isOfficeHour(cita.getDate())) {
            throw new NotOfficeHourException("hora cita " + cita.getDate() + " no horario de oficina");
        }
        if(service.isHourTaken(cita.getDate())){
            throw new HourTakenException("hora " + cita.getDate() + " esta tomada");
        }
        if(service.isHourTaken(cita.getEmail())) {
            throw new HourTakenException("email " + cita.getEmail() + " esta tomada");
        }
        service.addCita(cita);
    }
    
    public List<Cita> findAllCitas(){
        return service.getAgenda();
    }
}
