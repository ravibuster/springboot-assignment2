package com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordValidator.class})

public @interface PassWordValidation {
    String message() default "Password atleast contain one upperCase,lowercase,special character,numeric value and minimum length must be 8";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}