package com.benjamin.dancingWithDeath.services;

import com.benjamin.dancingWithDeath.model.Cita;
import com.benjamin.dancingWithDeath.utils.HourTakenException;
import com.benjamin.dancingWithDeath.utils.NotOfficeHourException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author benjamin
 */
@RunWith(SpringRunner.class)
public class DancingWithDeathServiceTest {

    private Cita citaValida;
    private Cita citaHoraInvalida;
    private Cita citaEmailInvalida;
    private Cita citaNotOfficeHour;

    @MockBean
    private IAgendaService agendaService;

    @TestConfiguration
    static class AgendaServiceTestConfig {

        @Bean
        DancingWithDeathService getDancingWithDeathService() {
            return new DancingWithDeathService();
        }
        /**
         *
         * @Bean AgendaService getAgendaService() { return new AgendaService();
         * }
         */
    }

    @Autowired
    private DancingWithDeathService service;

    @Before
    public void setup() {
        Calendar calendarHour = Calendar.getInstance();
        calendarHour.set(2019, 07, 01, 10, 0, 0);
        citaValida = new Cita(calendarHour.getTime(), "contacto@benjamin.com");
        citaHoraInvalida = new Cita(new Date(2019, 01, 01), "hora-invalida@benjamin.com");
        citaNotOfficeHour = new Cita(new Date(2019, 01, 02), "not-office-hour@benjamin.com");
        citaEmailInvalida = new Cita(new Date(2019, 01, 01), "email-invalido@benjamin.com");
        
        Mockito.when(agendaService.validateInfo(citaValida)).thenReturn(true);
        Mockito.when(agendaService.validateInfo(citaHoraInvalida)).thenReturn(true);
        Mockito.when(agendaService.validateInfo(citaNotOfficeHour)).thenReturn(true);
         Mockito.when(agendaService.validateInfo(citaEmailInvalida)).thenReturn(true);

        Mockito.when(agendaService.isOfficeHour(citaValida.getDate())).thenReturn(true);
        Mockito.when(agendaService.isOfficeHour(citaHoraInvalida.getDate())).thenReturn(true);
         Mockito.when(agendaService.isOfficeHour(citaEmailInvalida.getDate())).thenReturn(true);
        Mockito.when(agendaService.isOfficeHour(citaNotOfficeHour.getDate())).thenReturn(false);

        Mockito.when(agendaService.isHourTaken(citaValida.getDate())).thenReturn(false);
        Mockito.when(agendaService.isHourTaken(citaHoraInvalida.getDate())).thenReturn(true);
        Mockito.when(agendaService.isHourTaken(citaNotOfficeHour.getDate())).thenReturn(false);
        Mockito.when(agendaService.isHourTaken(citaEmailInvalida.getDate())).thenReturn(true);

        /*
        Mockito.when(agendaService.isHourTaken(cita.getDate())).thenReturn(false);
        Mockito.when(agendaService.isHourTaken(citaHoraInvalida.getDate())).thenReturn(true);
        
        Mockito.when(agendaService.isHourTaken(cita.getEmail())).thenReturn(false);
        Mockito.when(agendaService.isOfficeHour(cita.getDate())).thenReturn(true);
        Mockito.when(agendaService.citasSize()).thenReturn(1);
         */
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwInvalidInfo() {
        Cita citaInvalida = new Cita(new Date(), "");
        service.appointmentHour(citaInvalida);
    }

    @Test(expected = NotOfficeHourException.class)
    public void throwHourNotOfiiceHour() {
        service.appointmentHour(citaNotOfficeHour);
    }

    @Test(expected = HourTakenException.class)
    public void throwHourTakenByHour() {
        service.appointmentHour(citaHoraInvalida);
    }

    @Test(expected = HourTakenException.class)
    public void throwHourTakenByEmail() {
        service.appointmentHour(citaHoraInvalida);
    }

}
