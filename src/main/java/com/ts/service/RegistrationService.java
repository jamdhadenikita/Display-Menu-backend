package com.ts.service;

import com.ts.model.Registration;
import com.ts.repository.RegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
	
    @Autowired
    private RegistrationRepository registrationRepository;
    
     
   public ResponseEntity<?> login(String email, String password){
	   
	   Optional<Registration> user = registrationRepository.findByEmail(email);
	   
	   String passwordCheck = user.get().getPassword();
	   
	   if(user.isPresent()) {
		   
		   if(passwordCheck.equals(password)) {
			   return new ResponseEntity<> (user, HttpStatus.OK);
		   }
		   else {
			   return new ResponseEntity<> ("password incorrect", HttpStatus.BAD_REQUEST);
		   }
	   }
	   return new ResponseEntity<> ("internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
	   
   }
    
    public ResponseEntity<?> saveRegistration(Registration registration) {
    	
    	if(registration != null) {
    		return new ResponseEntity<>(registrationRepository.save(registration), HttpStatus.CREATED);
		}
    	return new ResponseEntity<>("internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
      
	public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }
	
	 public Optional<Registration> getRegistrationById(Long id) {
	        return registrationRepository.findById(id);
	    }
	 
	 public Optional<Registration> getRegistrationById1(Long id) {
	        return registrationRepository.findById(id);
	    } 
	    
	public boolean deleteRegistrationById(Long id) {
	    Optional<Registration> registration = registrationRepository.findById(id);
	    if (registration.isPresent()) {
	        registrationRepository.deleteById(id);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	 public void deleteRegistration(Long id) {
	        registrationRepository.deleteById(id);
	    }
	 
    
	 public void deleteAllRegistrations() {
	        registrationRepository.deleteAll();
	        }
	 
	 
	 public Registration updateRegistration(Long id, Registration updatedRegistration) {
	        // Find the existing registration by ID
	        Registration existingUser = registrationRepository.findById(id).orElse(null);

	        if (existingUser == null) {
	            return null;  // If the user doesn't exist, return null
	        }

	        // Update the user fields with the new data
	        existingUser.setFirstName(updatedRegistration.getFirstName());
	        existingUser.setLastName(updatedRegistration.getLastName());
	        existingUser.setEmail(updatedRegistration.getEmail());
	        existingUser.setMobile(updatedRegistration.getMobile());
	        existingUser.setGender(updatedRegistration.getGender());
	        existingUser.setDateOfBirth(updatedRegistration.getDateOfBirth());
	        existingUser.setAddress(updatedRegistration.getAddress());
	        existingUser.setCity(updatedRegistration.getCity());
	        existingUser.setAreaPIN(updatedRegistration.getAreaPIN());
	        existingUser.setState(updatedRegistration.getState());
	        existingUser.setPassword(updatedRegistration.getPassword());
	        existingUser.setConfirmPassword(updatedRegistration.getConfirmPassword());
	        
	        // Save the updated user back to the database
	        return registrationRepository.save(existingUser);
	    }
	 
	 
	 
	 
	 
}