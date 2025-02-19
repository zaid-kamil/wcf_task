package com.wcf.springboot_mvc_jpa_h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcf.springboot_mvc_jpa_h2.model.Employee;
import com.wcf.springboot_mvc_jpa_h2.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){
        return repo.findById(id);
    }

    public Employee addEmployee(Employee employee){
        return repo.save(employee);
    }

    public Employee updateEmployee(long id, Employee empDetails){
        Employee employee = repo.findById(id).orElseThrow(()-> new RuntimeException("Employee not found for id: "+id));
        
        employee.setName(empDetails.getName());
        employee.setPosition(empDetails.getPosition());
        employee.setSalary(empDetails.getSalary());

        return repo.save(employee);
    }

    public void deleteEmployee(Long id){
        repo.deleteById(id);
    }
}
