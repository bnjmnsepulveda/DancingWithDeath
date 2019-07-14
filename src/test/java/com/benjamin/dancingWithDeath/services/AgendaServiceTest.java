package com.benjamin.dancingWithDeath.services;

import com.benjamin.dancingWithDeath.model.Cita;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author benjamin
 */
@RunWith(SpringRunner.class)
public class AgendaServiceTest {

    @Autowired
    private IAgendaService service;
    
    @TestConfiguration
    static class AgendaServiceTestConfig{
        @Bean
        AgendaService getAgendaService() {
            return new AgendaService();
        }
    }

    @After
    public void onDestroy(){
        //service.setAgenda(new ArrayList());
    }
    
    @Test
    public void notAllowToBookMoreThan1AppointmentPerHour() {
        Calendar hour = Calendar.getInstance();
        hour.set(Calendar.MINUTE, 0);
        hour.set(Calendar.SECOND, 0);
        hour.set(Calendar.MILLISECOND, 0);
        service.addCita(new Cita(hour.getTime()));
        boolean isTaken = service.isHourTaken(hour.getTime());
        Assert.assertTrue(isTaken);
    }

    @Test
    public void isOfficeHourFrom09AmTo6Pm() {
        Calendar hour = Calendar.getInstance();
        hour.set(Calendar.HOUR_OF_DAY, 15);
        hour.set(Calendar.MINUTE, 0);
        hour.set(Calendar.SECOND, 0);
        hour.set(Calendar.MILLISECOND, 0);
        boolean added = service.isOfficeHour(hour.getTime());
        Assert.assertTrue(added);
    }

    @Test
    public void isOfficeHourMonday() {
        Calendar hour = Calendar.getInstance();
        hour.set(Calendar.DAY_OF_WEEK, 2);
        hour.set(Calendar.HOUR_OF_DAY, 15);
        hour.set(Calendar.MINUTE, 0);
        hour.set(Calendar.SECOND, 0);
        hour.set(Calendar.MILLISECOND, 0);
        boolean added = service.isOfficeHour(hour.getTime());
        Assert.assertTrue(added);
    }

    @Test
    public void isNotOfficeHourSaturday() {
        Calendar hour = Calendar.getInstance();
        hour.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        hour.set(Calendar.HOUR, 20);
        hour.set(Calendar.MINUTE, 0);
        hour.set(Calendar.SECOND, 0);
        hour.set(Calendar.MILLISECOND, 0);
        boolean added = service.isOfficeHour(hour.getTime());
        Assert.assertFalse(added);
    }

    @Test
    public void appointmentMustContainContactInformation() {
        boolean validated = service.validateInfo(new Cita(new Date(), "contacto@benjamin.com"));
        Assert.assertTrue(validated);
    }

    @Test
    public void appointmentContactIstaken() {
        service.addCita(new Cita(new Date(), "contacto@benjamin.com"));
        boolean isTaken = service.isHourTaken("contacto@benjamin.com");
        Assert.assertTrue(isTaken);
    }
    
    @Test
    public void appointmentContactIsNotTaken() {
       //service.addCita(new Cita(new Date(), "contacto@benjamin.com"));
        boolean isTaken = service.isHourTaken("contacto2@benjamin.com");
        Assert.assertFalse(isTaken);
    }
}
