package com.example.employeemanager.service;

import com.example.employeemanager.exception.userNotFoundException;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);

    }
    public List<Employee> findallEmployee(){
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeId(id).
                orElseThrow(()-> new userNotFoundException("user by Id" +id+"was not found"));
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeBYId(id);
    }



}
