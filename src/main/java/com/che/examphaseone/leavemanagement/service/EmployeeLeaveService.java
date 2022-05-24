package com.che.examphaseone.leavemanagement.service;

import java.util.Date;

import com.che.examphaseone.leavemanagement.model.EmployeeLeave;

public interface EmployeeLeaveService {

	/**
	 * Create employee leave form
	 */
	EmployeeLeave createEmployeeLeavRequest(Integer employeeId, Integer leaveId, Date startDate, Date endDate);

}
