package com.employee.attendance.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Entity class representing an employee event, such as clock-in or clock-out.
 */
@Document(value = "entryEvents")
public class EmployeeEvent {
    /**
     * Unique identifier for the employee event.
     */
    @Id
    @Indexed(unique = true)
    private String id;

    /**
     * The ID of the employee associated with the event.
     */
    @Getter
    @Setter
    private int employeeId;

    /**
     * The entry status of the employee (e.g., "IN" for clocked in, "OUT" for clocked out).
     */
    @Setter
    @Getter
    private EntryStatus entryStatus;

    /**
     * The timestamp when the event occurred.
     */
    @Setter
    @Getter
    private LocalDateTime timestamp;
}
