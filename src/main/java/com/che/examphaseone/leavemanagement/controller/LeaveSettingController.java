package com.che.examphaseone.leavemanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.che.examphaseone.leavemanagement.model.LeaveSetting;
import com.che.examphaseone.leavemanagement.service.LeaveSettingService;

@RestController
public class LeaveSettingController {
	@Autowired
	private LeaveSettingService leavesettingservice;

	@GetMapping("/api/v1/getAllLeaveSettings")
	public List<LeaveSetting> findAllLeaveSettings() {

		List<LeaveSetting> leaveSettingList = leavesettingservice.findAllLeaveSettings();
		Map<String, Object> map = new HashMap<String, Object>();
		// return providerservice.getProviders();
		JSONArray leaveSettings = new JSONArray();
		for (int i = 0; i < leaveSettingList.size(); i++) {
			JSONObject val = new JSONObject();

			val.put("leaveType", leaveSettingList.get(i).getLeaveType());
			val.put("leaveBalance", leaveSettingList.get(i).getLeaveBalance());
			leaveSettings.add(val);
		}

		return leaveSettings;
	}
}
