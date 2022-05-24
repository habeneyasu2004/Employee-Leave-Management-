package com.che.examphaseone.leavemanagement.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.che.examphaseone.leavemanagement.model.Employee;
import com.che.examphaseone.leavemanagement.model.EmployeeLeave;
import com.che.examphaseone.leavemanagement.repository.EmployeeLeaveRepository;
import com.che.examphaseone.leavemanagement.repository.EmployeeRepository;
import com.che.examphaseone.leavemanagement.service.EmployeeLeaveService;

@RestController
public class EmployeeLeaveController {

	@Autowired
	private EmployeeLeaveService employeeleaveservice;
	@Autowired
	private EmployeeLeaveRepository employeeleaverepository;
	@Autowired
	private EmployeeRepository employeerepo;

	@PostMapping("/api/v1/createLeaveRequest")
	public EmployeeLeave createEmployeeLeavRequest(Integer employeeId, Integer leaveTypeId, Integer noDays,
			String startDate) throws ParseException {

		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		// manipulate date
		cal.add(Calendar.DATE, noDays);
		Date enddate = cal.getTime();

		Date startdate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);

		return employeeleaveservice.createEmployeeLeavRequest(employeeId, leaveTypeId, startdate, enddate);
	}

	@GetMapping("/api/v1/getEmployeeRole/{username}")
	public String getEmployee(@PathVariable String username) {
		Employee employeeRole = employeerepo.findEmployeeByUsername(username);
		if (employeeRole != null) {
			return employeeRole.getRole();
		}
		return null;
	}

	@GetMapping("/api/v1/getLeaveRequest")
	public List<EmployeeLeave> getEmployeeLeavRequest(String username) {

		Employee role = employeerepo.findEmployeeByUsername(username);

		if (role != null && role.getRole() == "Employee") {
			Employee empId = new Employee();
			empId.setId(role.getId());
			return employeeleaverepository.findEmployeeLeaveByEmployeeId(empId);
		}
		return employeeleaverepository.findEmployeeLeaveByStatus(0);
	}

	@GetMapping("/api/v1/approveLeaveRequest")
	public EmployeeLeave approveLeaveRequest(Integer id, Integer employeeId, Integer approverId) {
		Employee employeeObj = new Employee();
		employeeObj.setId(employeeId);
		Employee approvedBy = new Employee();
		approvedBy.setId(approverId);
		Integer status = 0;
		EmployeeLeave checkLeave = employeeleaverepository.findEmployeeLeave(id, employeeObj, status);
		if (checkLeave != null) {
			checkLeave.setStatus(1);
			checkLeave.setApprovedBy(approvedBy);
			return employeeleaverepository.save(checkLeave);
		}
		return null;
	}
}
