package com.employee.attendance.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Data Transfer Object (DTO) representing an employee.
 */
@Data
public class EmployeeDto implements Serializable {

    /**
     * The name of the employee.
     */
    private String name;
}
