package com.employee.attendance;

import com.employee.attendance.entity.EmployeeEvent;
import com.employee.attendance.entity.EntryStatus;
import com.employee.attendance.repository.EmployeeEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;

/**
 * Main class for the Attendance Application.
 */
@SpringBootApplication
@Slf4j
public class AttendanceApplication {

    /**
     * Main method to start the Attendance Application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        // Start the Spring Boot application
        ConfigurableApplicationContext context = SpringApplication.run(AttendanceApplication.class, args);

        // Get the EmployeeEntryRepository bean from the application context
        EmployeeEntryRepository repository = context.getBean("repository", EmployeeEntryRepository.class);

        // Simulate employee attendance events and save them to the database
        simulateAttendanceEvents(repository);
    }

    /**
     * Simulates employee attendance events and saves them to the database.
     *
     * @param repository The repository used to save employee attendance events.
     */
    private static void simulateAttendanceEvents(EmployeeEntryRepository repository) {
        // Simulate attendance events for employee 1
        saveEmployeeEvent(repository, 1, EntryStatus.SWIPE_IN);
        saveEmployeeEvent(repository, 1, EntryStatus.SWIPE_OUT);

        // Simulate attendance events for employee 2
        saveEmployeeEvent(repository, 2, EntryStatus.SWIPE_IN);
        saveEmployeeEvent(repository, 2, EntryStatus.SWIPE_OUT);

        // Simulate attendance events for employee 3
        saveEmployeeEvent(repository, 3, EntryStatus.SWIPE_IN);
        saveEmployeeEvent(repository, 3, EntryStatus.SWIPE_OUT);
    }

    /**
     * Saves an employee attendance event to the database.
     *
     * @param repository  The repository used to save employee attendance events.
     * @param employeeId  The ID of the employee.
     * @param entryStatus The entry status of the attendance event.
     */
    private static void saveEmployeeEvent(EmployeeEntryRepository repository, int employeeId, EntryStatus entryStatus) {
        EmployeeEvent employeeEvent = new EmployeeEvent();
        employeeEvent.setEntryStatus(entryStatus);
        employeeEvent.setEmployeeId(employeeId);
        employeeEvent.setTimestamp(LocalDateTime.now());
        repository.save(employeeEvent);
    }
}
