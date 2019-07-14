package com.benjamin.dancingWithDeath.webapp;

import com.benjamin.dancingWithDeath.services.DancingWithDeathService;
import com.benjamin.dancingWithDeath.model.Cita;
import com.benjamin.dancingWithDeath.model.ResponseCita;
import com.benjamin.dancingWithDeath.model.ResponseError;
import com.benjamin.dancingWithDeath.utils.HourTakenException;
import com.benjamin.dancingWithDeath.utils.NotOfficeHourException;
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
    private DancingWithDeathService service;

    @PostMapping
    public ResponseCita appointmentHour(@RequestBody Cita cita) {
       return null;
    }

}
