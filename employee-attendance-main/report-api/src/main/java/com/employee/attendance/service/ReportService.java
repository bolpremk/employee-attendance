package com.employee.attendance.service;

import com.employee.attendance.dto.EmployeeDto;
import com.employee.attendance.dto.ReportDto;
import com.employee.attendance.entity.Employee;
import com.employee.attendance.entity.Report;
import com.employee.attendance.repository.EmployeeRepository;
import com.employee.attendance.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing report-related operations.
 */
@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * Retrieves report data.
     *
     * @return List of ReportDto objects representing report data.
     */
    public List<ReportDto> getReportData() {
        List<Report> reportList = reportRepository.findAll();
        List<ReportDto> reportDtos = reportList.stream()
                .map(r -> {
                    ReportDto reportDto = new ReportDto();
                    reportDto.setStatus(r.getStatus());
                    reportDto.setDate(r.getDate());
                    reportDto.setEmployeeId(r.getEmployee().getId());
                    reportDto.setName(r.getEmployee().getName());
                    return reportDto;
                }).toList();
        return reportDtos;
    }

    /**
     * Updates report data with the provided employee ID and status.
     *
     * @param employeeId The ID of the employee associated with the report.
     * @param status     The status to be updated.
     */
    public void updateReportData(Long employeeId, String status) {
        Report report = new Report();
        report.setDate(LocalDate.now());
        report.setStatus(status);
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        Employee employee = optionalEmployee.orElseGet(Employee::new);
        report.setEmployee(employee);
        reportRepository.save(report);
    }

    /**
     * Creates a new employee with the provided EmployeeDto object.
     *
     * @param e The EmployeeDto object containing employee information.
     * @return The created Employee object.
     */
    public Employee createEmployee(EmployeeDto e) {
        Employee employee= new Employee();
        employee.setName(e.getName());
        return employeeRepository.save(employee);
    }
}
