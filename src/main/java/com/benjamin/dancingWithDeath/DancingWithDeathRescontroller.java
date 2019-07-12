package com.benjamin.dancingWithDeath;

import com.benjamin.dancingWithDeath.model.Cita;
import com.benjamin.dancingWithDeath.model.ResponseError;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author benjamin
 */
@CrossOrigin
@RestController
@RequestMapping("/citas")
public class DancingWithDeathRescontroller {

    @Autowired
    private DancingWithDeathService service;

    @PostMapping
    public void appointmentHour(@RequestBody Cita cita) {
        service.appointmentHour(cita);
    }

    @GetMapping
    public List<Cita> findAllCitas() {
        return service.findAllCitas();
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseError> handleConflict(RuntimeException ex, WebRequest request) {
       
        return null;
    }
    
}
