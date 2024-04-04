package com.employee.attendance.controller;

import com.employee.attendance.dto.EmployeeDto;
import com.employee.attendance.entity.EmployeeEvent;
import com.employee.attendance.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class responsible for handling HTTP requests related to employee attendance.
 */
@RestController
@RequestMapping("/employee/v1")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * Retrieves the list of employee events by employee ID.
     *
     * @param id The ID of the employee.
     * @return ResponseEntity containing a list of EmployeeEvent objects.
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<List<EmployeeEvent>> getEventsById(@PathVariable Integer id) {
        List<EmployeeEvent> employeeEvents = employeeService.getEmployeeEvents(id);
        return ResponseEntity.ok(employeeEvents);
    }

    /**
     * Handles the employee swipe action and updates the employee event accordingly.
     *
     * @param employeeDto DTO containing information about the employee swipe action.
     * @return ResponseEntity containing the updated EmployeeEvent object.
     */
    @PostMapping("/swipe")
    public ResponseEntity<EmployeeEvent> swipe(@RequestBody EmployeeDto employeeDto) {
        EmployeeEvent employeeEvent = employeeService.updateEmployeeEvent(employeeDto);
        return ResponseEntity.ok(employeeEvent);
    }

    /**
     * Calculates the total hours worked by employees.
     *
     * @return ResponseEntity indicating the success of the operation.
     */
    @GetMapping("/calculate")
    public ResponseEntity<Void> calculateTotalHours() {
        employeeService.calculateTotalHours();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
