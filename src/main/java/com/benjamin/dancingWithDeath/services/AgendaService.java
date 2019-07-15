package com.benjamin.dancingWithDeath.services;

import com.benjamin.dancingWithDeath.model.Cita;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 *
 * @author benjamin
 */
@Service
public class AgendaService implements IAgendaService{

    @Getter
    @Setter
    private List<Cita> agenda = new ArrayList();

    @Override
    public boolean validateInfo(Cita cita) {
        return cita.getEmail() != null && !cita.getEmail().isEmpty();
    }

    @Override
    public boolean isHourTaken(Date date) {
        return agenda.stream().anyMatch((c) -> (c.getDate().equals(date)));
    }

    @Override
    public boolean isHourTaken(String contacto) {
        return agenda
                .stream()
                .anyMatch((c) -> (c.getEmail() != null && c.getEmail().equals(contacto)));
    }

    @Override
    public void addCita(Cita cita) {
        agenda.add(cita);
    }
    
    @Override
    public int citasSize(){
        return agenda.size();
    }

    @Override
    public boolean isOfficeHour(Date date) {
        int hour = date.getHours();
        Calendar c = Calendar.getInstance();
        c.set(date.getYear(), date.getMonth(), date.getDay());
        int dia = c.get(Calendar.DAY_OF_WEEK);
        if (dia != Calendar.SATURDAY || dia != Calendar.SUNDAY) {
            return hour > 9 && hour < 18;
        }
        return false;
    }

    @Override
    public List<Cita> findCitas() {
        return agenda;
    }

}
