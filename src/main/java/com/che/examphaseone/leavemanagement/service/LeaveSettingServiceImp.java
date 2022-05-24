package com.che.examphaseone.leavemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.che.examphaseone.leavemanagement.model.LeaveSetting;
import com.che.examphaseone.leavemanagement.repository.LeaveSettingRepository;

@Service
public class LeaveSettingServiceImp implements LeaveSettingService {

	@Autowired
	private LeaveSettingRepository leavesettingrepo;

	/**
	 * Find all leave settings
	 */
	public List<LeaveSetting> findAllLeaveSettings() {
		return leavesettingrepo.findAll();
	}
}
