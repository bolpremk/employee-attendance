package com.employee.attendance.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) representing a report entry.
 */
@Data
public class ReportDto implements Serializable {

    /**
     * The ID of the employee.
     */
    private long employeeId;

    /**
     * The name of the employee.
     */
    private String name;

    /**
     * The status of the employee.
     */
    private String status;

    /**
     * The date of the report entry.
     */
    private LocalDate date;
}
