package com.benjamin.dancingWithDeath.services;

import com.benjamin.dancingWithDeath.DancingWithDeathService;
import com.benjamin.dancingWithDeath.model.Cita;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author benjamin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DancingWithDeathServiceTest {

    @Autowired
    private DancingWithDeathService service;
    
    @Test
    public void appointmentHour(){
        service.appointmentHour(new Cita(new Date(), "contacto@benjamin.com"));
        int citasCant = service.findAllCitas().size();
        Assert.assertEquals(1, citasCant);
    }
}
