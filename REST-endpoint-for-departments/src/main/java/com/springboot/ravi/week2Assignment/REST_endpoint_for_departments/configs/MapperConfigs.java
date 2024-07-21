package com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.configs;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfigs {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}