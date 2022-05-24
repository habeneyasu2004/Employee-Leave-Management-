package com.che.examphaseone.leavemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.che.examphaseone.leavemanagement.model.Employee;
import com.che.examphaseone.leavemanagement.model.EmployeeLeave;

@Repository
public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Integer> {
	/**
	 * Find employee leave
	 */
	@Query(value = "SELECT * FROM 	employee_leave where id=:employeeLeaveId and employee_id=:employeeId and status=:status ORDER by start_date DESC", nativeQuery = true)
	EmployeeLeave findEmployeeLeave(@Param("employeeLeaveId") Integer employeeLeaveId,
			@Param("employeeId") Employee employeeId, @Param("status") Integer status);

	List<EmployeeLeave> findEmployeeLeaveByEmployeeId(@Param("employeeId") Employee employeeId);

	List<EmployeeLeave> findEmployeeLeaveByStatus(@Param("status") Integer status);

}
