package com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.entities;

import com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.annotations.PassWordValidation;
import com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.annotations.PrimeNumberValidation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")

public class DepartmentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Boolean isActive;
    private LocalDate createdAt;
    private Integer prime;
    private String password;

}
