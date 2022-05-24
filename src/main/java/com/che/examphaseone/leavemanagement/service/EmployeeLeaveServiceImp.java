package com.che.examphaseone.leavemanagement.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.che.examphaseone.leavemanagement.model.Employee;
import com.che.examphaseone.leavemanagement.model.EmployeeLeave;
import com.che.examphaseone.leavemanagement.model.LeaveSetting;
import com.che.examphaseone.leavemanagement.repository.EmployeeLeaveRepository;

@Service
public class EmployeeLeaveServiceImp implements EmployeeLeaveService {
	@Autowired
	private EmployeeLeaveRepository employeeleaverepo;

	/**
	 * Create employee leave form
	 */
	public EmployeeLeave createEmployeeLeavRequest(Integer employeeId, Integer leaveId, Date startDate, Date endDate) {

		EmployeeLeave employeeLeave = new EmployeeLeave();
		Employee empID = new Employee();
		empID.setId(employeeId);

		LeaveSetting leaveID = new LeaveSetting();
		leaveID.setId(leaveId);

		employeeLeave.setEmployeeId(empID);
		employeeLeave.setLeaveId(leaveID);
		employeeLeave.setStartDate(startDate);
		employeeLeave.setEndDate(endDate);

		return employeeleaverepo.save(employeeLeave);
	}
}
