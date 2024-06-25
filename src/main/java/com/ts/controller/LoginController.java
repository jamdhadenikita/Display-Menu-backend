package com.ts.controller;

import com.ts.model.Login;
import com.ts.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public Login registerLogin(@RequestBody Login login) {
        return loginService.saveLogin(login);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestBody Login login) {
        Login foundLogin = loginService.findByUserName(login.getUserName());

        if (foundLogin != null && foundLogin.getPassword().equals(login.getPassword())) {
            return ResponseEntity.ok("Authentication successful");
        } else {
            return ResponseEntity.status(401).body("Authentication failed");
        }
    }
}

