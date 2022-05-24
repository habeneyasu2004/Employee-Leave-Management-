package com.che.examphaseone.leavemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.che.examphaseone.leavemanagement.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	/**
	 * Get employee by ID
	 */

	Employee findEmployeeByUsername(@Param("username") String username);
}
