package com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.DTO;

import com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.annotations.PassWordValidation;
import com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.annotations.PrimeNumberValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentsDTO {
    private Long id;
    @NotBlank(message = "Required field in Department : title")
    private String title;
    @AssertTrue(message = "isActive always true")
    private Boolean isActive;
    @PastOrPresent(message = "future date cannot take")
    private LocalDate createdAt;
    @PrimeNumberValidation
    private Integer prime;
    @PassWordValidation
    @NotNull
    private String password;
}
