package com.wcf.springboot_mvc_jpa_h2.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcf.springboot_mvc_jpa_h2.model.Employee;
import com.wcf.springboot_mvc_jpa_h2.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Display list of employees
    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee";
    }

    // Show form to add a new employee
    @GetMapping("/new")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee_form";
    }

    // Save a new employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        if (employee.getId() != null) {
            employeeService.updateEmployee(employee.getId(), employee);
        } else {
            employeeService.addEmployee(employee);
        }
        return "redirect:/employees";
    }

    // Show form to edit an existing employee
    @GetMapping("/edit/{id}")
    public String showEditEmployeeForm(@PathVariable Long id, Model model) {
        Optional<Employee> employeeOpt = employeeService.getEmployeeById(id);
        if (employeeOpt.isPresent()) {
            model.addAttribute("employee", employeeOpt.get());
            return "employee_form";
        }
        return "redirect:/employees";
    }

    // Update an existing employee using form submission
    @PostMapping("/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee) {
        employeeService.updateEmployee(id, employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> e = employeeService.getEmployeeById(id);
        if (e.isPresent()) {
            return ResponseEntity.ok(e.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
