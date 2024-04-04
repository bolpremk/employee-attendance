package com.employee.attendance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

/**
 * Entity class representing a report entry.
 */
@Entity
@Table(name = "tbl_report")
@DynamicUpdate
public class Report {
    /**
     * The unique identifier for the report.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The employee associated with the report.
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "emp_id")
    @Getter
    @Setter
    private Employee employee;

    /**
     * The date of the report entry.
     */
    @Column
    @Getter
    @Setter
    private LocalDate date;

    /**
     * The status of the report entry.
     */
    @Column
    @Getter
    @Setter
    private String status;

}
