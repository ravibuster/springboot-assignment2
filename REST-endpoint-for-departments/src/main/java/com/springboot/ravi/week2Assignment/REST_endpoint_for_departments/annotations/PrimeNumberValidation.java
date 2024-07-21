package com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PrimeNumberValidator.class})

public @interface PrimeNumberValidation {
    String message() default "Number is not Prime";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
