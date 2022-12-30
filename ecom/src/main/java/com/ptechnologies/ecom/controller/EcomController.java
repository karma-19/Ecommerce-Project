package com.ptechnologies.ecom.controller;

import com.ptechnologies.ecom.entity.SignUp;
import com.ptechnologies.ecom.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class EcomController {
    @Autowired
    private SignUpService signUpService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/signup")
    public void signup(@RequestBody SignUp signUp) {
        try {
            signUpService.signup(signUp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/get-all-signup")
    public List<SignUp> getAllSignUp() {
        try {
            return signUpService.getAllSignup();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
