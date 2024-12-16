package com.ts.controller;

import com.ts.model.Registration;
import com.ts.service.RegistrationService;
import java.util.List;
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
    
    @PostMapping("/saveInfo")
    public ResponseEntity<?> registerUser(@RequestBody Registration registration) {
    	return new  ResponseEntity<>(registrationService.saveRegistration(registration),HttpStatus.OK);
    }
    
    @GetMapping("/login")
	public ResponseEntity<?> login(@RequestParam("email") String email, @RequestParam("password") String password) {
		return registrationService.login(email,password);
	}
    
    @GetMapping("/getallregisteruser")
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        List<Registration> registrations = registrationService.getAllRegistrations();
        return ResponseEntity.ok(registrations);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRegistrationById(@PathVariable("id") Long id) {
        boolean isDeleted = registrationService.deleteRegistrationById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }
   @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllRegistrations() {
        registrationService.deleteAllRegistrations();
        return ResponseEntity.noContent().build();
    }
   
   
   @PutMapping("/edit/{id}")
   public ResponseEntity<Registration> editUser(@PathVariable("id") Long id, @RequestBody Registration updatedRegistration) {
       Registration updatedUser = registrationService.updateRegistration(id, updatedRegistration);

       if (updatedUser == null) {
           return ResponseEntity.notFound().build();  // If the user is not found, return 404
       }

       return ResponseEntity.ok(updatedUser);  // Return the updated user details
   }
   
   
   
   
  
   
   
    
}
