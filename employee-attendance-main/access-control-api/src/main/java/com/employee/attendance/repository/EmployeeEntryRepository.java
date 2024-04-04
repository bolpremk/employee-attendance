package com.employee.attendance.repository;

import com.employee.attendance.entity.EmployeeEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing employee entry events.
 */
@Repository(value = "repository")
public interface EmployeeEntryRepository extends MongoRepository<EmployeeEvent, Integer> {
    /**
     * Retrieves a list of employee events based on the employee ID.
     *
     * @param employeeId The ID of the employee.
     * @return A list of EmployeeEvent objects associated with the given employee ID.
     */
    @Query(value = "{employeeId:?0}", sort = "{timestamp:1}")
    List<EmployeeEvent> getEmployeeEventsById(Integer employeeId);
}
