package com.employee.attendance.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) representing an employee and their attendance status.
 */
@Data
public class EmployeeDto {

    /**
     * The ID of the employee.
     */
    private int employeeId;

    /**
     * The status of the employee's attendance (e.g., "IN" for clocked in, "OUT" for clocked out).
     */
    private String status;
}
