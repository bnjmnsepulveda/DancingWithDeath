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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.benjamin.dancingWithDeath.services.IDancingWithDeathService;
import org.junit.Before;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author benjamin
 */
@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
@WebMvcTest(DancingWithDeathRescontroller.class)
public class DancingWithDeathRescontrollerTest {

    @Autowired
    private MockMvc mvc;
    private Cita cita;
 
    @MockBean
    private IDancingWithDeathService service; 
    
    @TestConfiguration
    static class AgendaServiceTestConfig{
       /*
         @Bean
        DancingWithDeathService getDancingWithDeathService() {
            return new DancingWithDeathService();
        }
        @Bean
        AgendaService getAgendaService() {
            return new AgendaService();
        }
        */
        
    }
    
    @Before
    public void setup(){
        cita = new Cita(new Date(2019, 01, 01), "contacto@benjamin.com");
        Mockito.when(service.appointmentHour(cita)).thenReturn(cita);
    }
    
    @Test
    public void appointmentHour() throws Exception {
      mvc.perform(post("dancing-with-death-api/citas"))
              .andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

}
