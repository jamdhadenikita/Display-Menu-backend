package com.ts.controller;

import com.ts.model.Registration;
import com.ts.model.RegistrationStats;
import com.ts.service.RegistrationService;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

//    @PostMapping("/saveInfo")
//    public ResponseEntity<?> registerUser(@RequestBody Registration registration) {
//    	       
//        return registrationService.saveRegistration(registration);
//    }
    
    
    @PostMapping("/saveInfo")
    public ResponseEntity<Registration> registerUser(@RequestBody Registration registration) {
        Registration savedRegistration = registrationService.saveRegistration(registration.getFirstName(),
        																	  registration.getLastName(),registration.getEmail(),registration.getMobile(),
        																	  registration.getGender(),registration.getDateOfBirth(),registration.getAddress(),
        																	  registration.getCity(),registration.getAreaPIN(),registration.getState(),
        																	  registration.getPassword());
        return ResponseEntity.ok(savedRegistration);
    }
    
    
    
    @GetMapping("/getallregisteruser")
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        List<Registration> registrations = registrationService.getAllRegistrations();
        return ResponseEntity.ok(registrations);
    }

//    @GetMapping("/registrations-by-month")
//    public ResponseEntity<List<RegistrationStats>> getRegistrationsByMonth() {
//        List<Object[]> result = registrationService.getRegistrationsGroupedByMonth();
//        List<RegistrationStats> stats = result.stream()
//            .map(data -> new RegistrationStats((Integer) data[0], (Long) data[1]))
//            .collect(Collectors.toList());
//        return ResponseEntity.ok(stats);
//    }
    
 // DELETE API for deleting a specific registration by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRegistrationById(@PathVariable("id") Long id) {
        boolean isDeleted = registrationService.deleteRegistrationById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if the registration ID is not found
        }
    }

    
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllRegistrations() {
        registrationService.deleteAllRegistrations();
        return ResponseEntity.noContent().build();
    }
    
}
