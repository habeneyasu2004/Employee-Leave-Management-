package com.che.examphaseone.leavemanagement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the employee_leave database table.
 * 
 */
@Entity
@Table(name = "employee_leave")
@NamedQuery(name = "EmployeeLeave.findAll", query = "SELECT e FROM EmployeeLeave e")
public class EmployeeLeave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "approved_by", referencedColumnName = "id")
	private Employee approvedBy;

	@OneToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employeeId;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	@OneToOne
	@JoinColumn(name = "leave_id", referencedColumnName = "id")
	private LeaveSetting leaveId;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	private int status;

	public EmployeeLeave() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(Employee approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Employee getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public LeaveSetting getLeaveId() {
		return this.leaveId;
	}

	public void setLeaveId(LeaveSetting leaveId) {
		this.leaveId = leaveId;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}