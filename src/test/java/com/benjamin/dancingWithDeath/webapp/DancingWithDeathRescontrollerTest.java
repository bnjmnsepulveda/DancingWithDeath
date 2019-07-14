package com.benjamin.dancingWithDeath.webapp;

import com.benjamin.dancingWithDeath.model.Cita;
import com.benjamin.dancingWithDeath.model.ResponseCita;
import com.benjamin.dancingWithDeath.services.AgendaService;
import com.benjamin.dancingWithDeath.services.DancingWithDeathService;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author benjamin
 */
@RunWith(SpringRunner.class)
public class DancingWithDeathRescontrollerTest {

    @TestConfiguration
    static class AgendaServiceTestConfig{
        @Bean
        DancingWithDeathService getDancingWithDeathService() {
            return new DancingWithDeathService();
        }
        @Bean
        AgendaService getAgendaService() {
            return new AgendaService();
        }
    }
    
    @Test
    public void saveCitaTest() {
      
    }

}
