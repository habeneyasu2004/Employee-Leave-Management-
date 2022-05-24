package com.che.examphaseone.leavemanagement.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the leave_setting database table.
 * 
 */
@Entity
@Table(name="leave_setting")
@NamedQuery(name="LeaveSetting.findAll", query="SELECT l FROM LeaveSetting l")
public class LeaveSetting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="allowed_for")
	private String allowedFor;

	@Column(name="leave_balance")
	private int leaveBalance;

	@Column(name="leave_type")
	private String leaveType;

	public LeaveSetting() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAllowedFor() {
		return this.allowedFor;
	}

	public void setAllowedFor(String allowedFor) {
		this.allowedFor = allowedFor;
	}

	public int getLeaveBalance() {
		return this.leaveBalance;
	}

	public void setLeaveBalance(int leaveBalance) {
		this.leaveBalance = leaveBalance;
	}

	public String getLeaveType() {
		return this.leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

}