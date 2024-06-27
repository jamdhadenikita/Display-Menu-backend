package com.ts.controller;

import com.ts.model.Registration;
import com.ts.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/saveInfo")
    public ResponseEntity<Registration> registerUser(@RequestBody Registration registration) {
        Registration savedRegistration = registrationService.saveRegistration(registration.getFirstName(),
        																	  registration.getLastName(),registration.getEmail(),registration.getMobile(),
        																	  registration.getGender(),registration.getDateOfBirth(),registration.getAddress(),
        																	  registration.getCity(),registration.getAreaPIN(),registration.getState(),
        																	  registration.getPassword());
        return ResponseEntity.ok(savedRegistration);
    }
    
}
