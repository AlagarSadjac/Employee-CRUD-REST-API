package com.alaga.Employee_CRUD_REST_API.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String name;
    private String email;
    private String department;

}