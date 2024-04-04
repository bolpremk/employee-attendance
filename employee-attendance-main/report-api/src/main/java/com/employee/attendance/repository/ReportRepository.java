package com.employee.attendance.repository;

import com.employee.attendance.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Report entities.
 */
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
