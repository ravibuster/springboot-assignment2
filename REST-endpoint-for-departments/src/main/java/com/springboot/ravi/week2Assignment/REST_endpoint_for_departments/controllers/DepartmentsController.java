package com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.controllers;

import com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.DTO.DepartmentsDTO;
import com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.exceptions.ResourceNotFoundException;
import com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "departments")
public class DepartmentsController {
    private  final DepartmentService departmentService;

    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentsDTO> getDepartmentById(@PathVariable (name = "departmentId" ) Long id){
        Optional<DepartmentsDTO> departmentsDTO = departmentService.getDepartmentById(id);
        return departmentsDTO
                .map(departmentsDTO1 -> ResponseEntity.ok(departmentsDTO1))
                .orElseThrow(() -> new ResourceNotFoundException("Department is not found with id: "+ id));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentsDTO>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<DepartmentsDTO> createNewDepartments(@RequestBody @Valid DepartmentsDTO inputDepartment){
        DepartmentsDTO departmentsDTO = departmentService.createNewDepartments(inputDepartment);
        return new ResponseEntity<>(departmentsDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentsDTO> updateDepartmentById(@RequestBody @Valid DepartmentsDTO departmentsDTO ,@PathVariable(name = "departmentId") Long id ) {
        return ResponseEntity.ok(departmentService.updateDepartmentById(id,departmentsDTO));
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable  Long departmentId){
        boolean gotDeleted = departmentService.deleteEmployeeById(departmentId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{departmentId}")
    public ResponseEntity<DepartmentsDTO> updatePartiallyDepartmentById(@RequestBody @Valid Map<String,Object> updates, @PathVariable Long departmentId){
        DepartmentsDTO departmentsDTO = departmentService.updatePartiallyDepartmentById(updates,departmentId);
        if (departmentsDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(departmentsDTO);
    }
}



