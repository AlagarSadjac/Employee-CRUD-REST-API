package com.alaga.Employee_CRUD_REST_API.repository;

import com.alaga.Employee_CRUD_REST_API.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
