package com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.annotations;

import com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.exceptions.ResourceNotFoundException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation,Integer> {
    @Override
    public boolean isValid(Integer num, ConstraintValidatorContext context) {
        if (num == null) {

            throw new ResourceNotFoundException("Null value is not allowed");
        }
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }

        int sqrtNum = (int) Math.sqrt(num) + 1;
        for (int i = 3; i < sqrtNum; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
