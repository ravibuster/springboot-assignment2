package com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<PassWordValidation,String> {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if(password == null){
            return false;
        }
        return Pattern.matches(PASSWORD_PATTERN,password);
    }
}
