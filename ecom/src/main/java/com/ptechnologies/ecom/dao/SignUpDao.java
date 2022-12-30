package com.ptechnologies.ecom.dao;

import com.ptechnologies.ecom.entity.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SignUpDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Retryable(backoff = @Backoff(delay = 100))
    public int save(SignUp signUp) throws SQLException {
        try {
            String query = String.format("INSERT INTO signup VALUES('%s', '%s', '%s', '%s', '%s')",
                    signUp.getFirstName(),
                    signUp.getLastName(),
                    signUp.getEmail(),
                    signUp.getMobileNumber(),
                    signUp.getPassword());
            return jdbcTemplate.update(query);
        } catch (Exception e) {
            throw new SQLException("Signup data insertion failed.");
        }
    }

    @Retryable(backoff = @Backoff(delay = 100))
    public List<SignUp> getAll() throws SQLException {
        try {
            return jdbcTemplate.query("select * from signup", new RowMapper<SignUp>() {
                @Override
                public SignUp mapRow(ResultSet rs, int rownumber) throws SQLException {
                    SignUp e = new SignUp();
                    e.setFirstName(rs.getString(1));
                    e.setLastName(rs.getString(2));
                    e.setEmail(rs.getString(3));
                    e.setMobileNumber((rs.getString(4)));
                    e.setPassword((rs.getString(5)));
                    return e;
                }
            });
        } catch (Exception e) {
            throw new SQLException("Getting all signup failed.");
        }

    }
}
