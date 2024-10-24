//package com.ts.controller;
//
//import com.ts.model.Registration;
//import com.ts.service.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin("*")
//@RequestMapping("/api/login")
//public class LoginController {
//
//    @Autowired
//    private LoginService loginService;
//  
//    
////    @PostMapping("/login")
////    public ResponseEntity<?> login(@RequestParam("email") String email ){
////    	return loginService.login(email);
////    }
//    
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestParam("emailOrMobile") String emailOrMobile, 
//                                   @RequestParam("password") String password) {
//        return loginService.login(emailOrMobile, password);
//    }
//
//   
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody Registration registration) {
//        return loginService.registerUser(registration);
//    }
//    
//}
//
