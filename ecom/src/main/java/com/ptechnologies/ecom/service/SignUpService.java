package com.ptechnologies.ecom.service;

import com.ptechnologies.ecom.dao.SignUpDao;
import com.ptechnologies.ecom.entity.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SignUpService {

    @Autowired
    private SignUpDao signUpDao;

    public int signup(SignUp signUp) throws SQLException {
        return signUpDao.save(signUp);
    }

    public List<SignUp> getAllSignup() throws SQLException {
        return signUpDao.getAll();
    }
}
