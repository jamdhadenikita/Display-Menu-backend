package com.ts.service;

import com.ts.model.Registration;
//import com.ts.repository.LoginRepository;
import com.ts.repository.RegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;
    
//    @Autowired
//    private LoginRepository loginRepository;

   
    public Optional<Registration> getRegistrationById(Long id) {
        return registrationRepository.findById(id);
    }
    

    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }
    

//	public ResponseEntity<?>  saveRegistration(Registration registration) {
//		
//		Registration user = registrationRepository.findByEmail(registration.getEmail());
//		
//		String emailCheck = user.getEmail();
//		
//		if(!registration.getEmail().equals(emailCheck)) {
//			
//			return new ResponseEntity<>(registrationRepository.save(registration), HttpStatus.CREATED);
//			
//		}else {
//			return new ResponseEntity<>("internal server error", HttpStatus.BAD_REQUEST);		
//		}
//	}
    
    public Registration saveRegistration(String firstName, String lastName, String email, String mobile, String gender,
			String dateOfBirth, String address, String city, String areaPIN, String state, String password) {
		
		Registration registration = new  Registration();
		
		registration.setFirstName(firstName);
		registration.setLastName(lastName);
		registration.setEmail(email);
		registration.setMobile(mobile);
		registration.setGender(gender);
		registration.setDateOfBirth(dateOfBirth);
		registration.setAddress(address);
		registration.setCity(city);
		registration.setAreaPIN(areaPIN);
		registration.setState(state);
		registration.setPassword(password);
		
		return registrationRepository.save(registration);
	}
	
      
	public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
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
	
	
	// Method to register a new user (already discussed)
    public Registration registerUser(Registration registration) {
        LocalDateTime now = LocalDateTime.now();
        registration.setRegistrationDateTime(now);
        return registrationRepository.save(registration);
    }
    

    // Method to get registrations grouped by month
//    public List<Object[]> getRegistrationsGroupedByMonth() {
//        return registrationRepository.findRegistrationsGroupedByMonth();
//    }
    
    
	 public void deleteAllRegistrations() {
	        registrationRepository.deleteAll();
	    }
	 
	 
}
