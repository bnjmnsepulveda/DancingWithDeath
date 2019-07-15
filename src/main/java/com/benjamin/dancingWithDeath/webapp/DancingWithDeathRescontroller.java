package com.benjamin.dancingWithDeath.webapp;

import com.benjamin.dancingWithDeath.services.DancingWithDeathService;
import com.benjamin.dancingWithDeath.model.Cita;
import com.benjamin.dancingWithDeath.model.ResponseCita;
import com.benjamin.dancingWithDeath.model.ResponseError;
import com.benjamin.dancingWithDeath.services.IDancingWithDeathService;
import com.benjamin.dancingWithDeath.utils.HourTakenException;
import com.benjamin.dancingWithDeath.utils.NotOfficeHourException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author benjamin
 */
@CrossOrigin
@RestController
@RequestMapping("/citas")
public class DancingWithDeathRescontroller {

    @Autowired
    private IDancingWithDeathService service;

    @PostMapping
    public ResponseCita appointmentHour(@RequestBody Cita cita) {
        return new ResponseCita(service.appointmentHour(cita), "successful", "cita added");
    }
    
    @GetMapping
    public java.util.List<Cita> findCitas(){
        return service.findCitas();
    }
    
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseCita handleError(IllegalArgumentException ex){
        return new ResponseCita(null, "failed", ex.getMessage());
    }
    
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(HourTakenException.class)
    public ResponseCita handleError(HourTakenException ex){
        return new ResponseCita(null, "failed", ex.getMessage());
    }
    
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NotOfficeHourException.class)
    public ResponseCita handleError(NotOfficeHourException ex){
        return new ResponseCita(null, "failed", ex.getMessage());
    }

}
