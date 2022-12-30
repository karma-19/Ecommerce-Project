package com.ptechnologies.ecom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUp {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String password;
}
