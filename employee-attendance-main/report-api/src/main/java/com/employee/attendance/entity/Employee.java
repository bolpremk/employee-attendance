package com.employee.attendance.entity;

import jakarta.persistence.*;

/**
 * Entity class representing an employee.
 */
@Getter
@Entity
@Table(name = "tbl_employee")
public class Employee {

    /**
     * The unique identifier for the employee.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the employee.
     */
    @Column
    @Setter
    private String name;
}
