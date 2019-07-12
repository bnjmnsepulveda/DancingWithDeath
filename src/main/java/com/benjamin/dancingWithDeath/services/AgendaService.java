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
public class AgendaService {

    @Getter
    @Setter
    private List<Cita> agenda = new ArrayList();

    public boolean validateInfo(Cita cita) {
        return cita.getEmail() != null && !cita.getEmail().isEmpty();
    }

    public boolean isHourTaken(Date date) {
        return agenda.stream().anyMatch((c) -> (c.getDate().equals(date)));
    }

    public boolean isHourTaken(String contacto) {
        return agenda
                .stream()
                .anyMatch((c) -> (c.getEmail() != null && c.getEmail().equals(contacto)));
    }

    public void addCita(Cita cita) {
        agenda.add(cita);
    }

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

}
