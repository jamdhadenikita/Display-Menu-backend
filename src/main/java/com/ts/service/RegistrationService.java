package com.ts.service;

import com.ts.model.Registration;
import com.ts.repository.RegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Optional<Registration> getRegistrationById(Long id) {
        return registrationRepository.findById(id);
    }

//    public Registration saveRegistration(Registration registration) {
//    	
//        return registrationRepository.save(registration);
//    }

    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

	public Registration saveRegistration(String firstName, String lastName, String email, String mobile, String gender,
			String dateOfBirth, String address, String city, String areaPIN, String state, String password) {
		// TODO Auto-generated method stub
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
}
