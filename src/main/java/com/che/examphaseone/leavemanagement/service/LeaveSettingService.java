package com.che.examphaseone.leavemanagement.service;

import java.util.List;

import com.che.examphaseone.leavemanagement.model.LeaveSetting;

public interface LeaveSettingService {

	/**
	 * Find all leave settings
	 */
	List<LeaveSetting> findAllLeaveSettings();

}
