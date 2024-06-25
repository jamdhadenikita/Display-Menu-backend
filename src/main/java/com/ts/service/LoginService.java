
package com.ts.service;

import com.ts.model.Login;
import com.ts.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public Login findByUserName(String userName) {
        return loginRepository.findByUserName(userName);
    }

    public Login saveLogin(Login login) {
        return loginRepository.save(login);
    }
}
