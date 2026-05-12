package com.alaga.Employee_CRUD_REST_API.controller;

import com.alaga.Employee_CRUD_REST_API.exception.ResourceNotFoundException;
import com.alaga.Employee_CRUD_REST_API.model.Employee;
import com.alaga.Employee_CRUD_REST_API.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/employees")
    public class EmployeeController
    {
        @Autowired
        private EmployeeRepository repository;

        // 1. Get
        @GetMapping
        public List<Employee> getAllEmployees()
        {
            return repository.findAll();
        }

        @GetMapping("/{id}")
        public Employee getEmployeeById(@PathVariable Long id)
        {
            return repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id !"+" "+id));
        }

        // 2. Post
        @PostMapping
        public Employee createEmployee(@RequestBody Employee employee)
        {
            return repository.save(employee);
        }

        // 3. DELETE
        @DeleteMapping("/{id}")
        public String deleteEmployee(@PathVariable Long id) {
            repository.deleteById(id);
            return "Employee deleted successfully with ID: " + id;
        }

        // 4. UPDATE
        @PutMapping("/{id}")
        public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails)
        {
            Employee employee = repository.findById(id).get(); // Fetch the existing employee data

            employee.setName(employeeDetails.getName()); // Update the employee details with new values
            employee.setEmail(employeeDetails.getEmail());
            employee.setDepartment(employeeDetails.getDepartment());

            return repository.save(employee); // Save the update employee date back to the database
        }

    }



