package com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.repositories;

import com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.entities.DepartmentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<DepartmentsEntity,Long> {
}
