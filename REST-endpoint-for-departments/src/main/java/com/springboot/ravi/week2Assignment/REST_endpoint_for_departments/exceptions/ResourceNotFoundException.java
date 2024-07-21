package com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String messsage){
        super(messsage);
    }
}
