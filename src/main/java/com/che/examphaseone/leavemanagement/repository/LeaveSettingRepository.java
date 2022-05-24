package com.che.examphaseone.leavemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.che.examphaseone.leavemanagement.model.LeaveSetting;

@Repository
public interface LeaveSettingRepository extends JpaRepository<LeaveSetting, Integer> {

}
