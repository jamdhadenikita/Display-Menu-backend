//
//package com.ts.service;
//
//import com.ts.model.Login;
//import com.ts.model.Registration;
//import com.ts.repository.LoginRepository;
//import com.ts.repository.RegistrationRepository;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LoginService {
//	
//	
//    @Autowired
//    private LoginRepository loginRepository;
//    
//    @Autowired
//    RegistrationRepository registrationRepository;
//
//
//    public ResponseEntity<?> login(String email,String password) {
//    	
//    	Registration user = registrationRepository.findByEmail(email);
//    	
//    	String emailCheck = user.getEmail();
//    	
//    	if(!email.equals(emailCheck)) {
//    		return new ResponseEntity<>(user,HttpStatus.OK);
//    		
//    	}else {
//    		return new ResponseEntity<>("user not present",HttpStatus.BAD_REQUEST);
//    	}
//        
//    }
//}
//
//
//////////////////////////////////////////


