package com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.services;

import com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.DTO.DepartmentsDTO;
import com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.entities.DepartmentsEntity;
import com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.exceptions.ResourceNotFoundException;
import com.springboot.ravi.week2Assignment.REST_endpoint_for_departments.repositories.DepartmentsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentsRepository departmentsRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentsRepository departmentsRepository, ModelMapper modelMapper) {
        this.departmentsRepository = departmentsRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<DepartmentsDTO> getDepartmentById(Long id) {
         return departmentsRepository
                 .findById(id)
                 .map(departmentsEntity -> modelMapper.map(departmentsEntity,DepartmentsDTO.class));
    }

    public List<DepartmentsDTO> getAllDepartments() {
        List<DepartmentsEntity> departmentsEntities = departmentsRepository.findAll();
        return departmentsEntities
                .stream()
                .map(departmentsEntity -> modelMapper.map(departmentsEntity,DepartmentsDTO.class))
                .collect(Collectors.toList());
    }

    public DepartmentsDTO createNewDepartments(DepartmentsDTO inputDepartment) {
        DepartmentsEntity toSaveDepartment = modelMapper.map(inputDepartment,DepartmentsEntity.class);
        DepartmentsEntity departmentsEntity = departmentsRepository.save(toSaveDepartment);
        return modelMapper.map(departmentsEntity, DepartmentsDTO.class);
    }

    public DepartmentsDTO updateDepartmentById(Long id,DepartmentsDTO departmentsDTO) {
        isExistDepartmentById(id);
        DepartmentsEntity departmentsEntity = modelMapper.map(departmentsDTO,DepartmentsEntity.class);
        departmentsEntity.setId(id);
        DepartmentsEntity saveDepartmentEntity = departmentsRepository.save(departmentsEntity);
        return modelMapper.map(saveDepartmentEntity,DepartmentsDTO.class);
    }

    public void isExistDepartmentById(Long id){
        boolean exists =  departmentsRepository.existsById(id);
        if (!exists) throw new ResourceNotFoundException("Employee not found with id :"+id);
    }

    public boolean deleteEmployeeById(Long departmentId) {
        isExistDepartmentById(departmentId);
        departmentsRepository.deleteById(departmentId);
        return true;
    }

    public DepartmentsDTO updatePartiallyDepartmentById(Map<String, Object> updates, Long departmentId) {
        isExistDepartmentById(departmentId);
        DepartmentsEntity departmentsEntity = departmentsRepository.findById(departmentId).get();
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(DepartmentsEntity.class, field);
            if (fieldToBeUpdated != null) {
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated, departmentsEntity, value);
            }
        });

        DepartmentsEntity toSaveEntity = departmentsRepository.save(departmentsEntity);
        return modelMapper.map(toSaveEntity, DepartmentsDTO.class);
    }

}

