package com.example.demo.domain.mission.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.mission.model.Mission;
import com.example.demo.domain.mission.service.MissionService;
import com.example.demo.repository.MissionMapper;

@Service
public class MissionServiceImpl implements MissionService {

	@Autowired
	MissionMapper mapper;

	/** 案件1件登録 */
	@Override
	public void insertMission(Mission mission) {
		mapper.insertOne(mission);
	}

	/** 案件一覧取得 */
	@Override
	public List<Mission> getMissionList() {
		return mapper.findMany();
	}

	/** 案件1件取得 */
	@Override
	public Mission getMissionDetail(int missionId) {
		return mapper.findOne(missionId);
	}

	/** 案件1件更新 */
	@Override
	public void updateMission(Mission mission) {
		mapper.updateOne(mission);
	}

	/** 案件削除 */
	@Override
	public void deleteMission(int missionId) {
		mapper.deleteOne(missionId);
	}

	/** 従業員アサイン */
	@Override
	public void assignEmployeeToMission(int employeeId, int missionId) {
		mapper.joinEmployeeToMission(employeeId, missionId);
	}

	/** アサインされた従業員を表示
	@Override
	public Mission getAssignedEmployee(int missionId) {
		return mapper.findAssignedOne(missionId);
	}*/

	/** 日報と案件をコネクト */
	@Override
	public void connectMissionToReport(int missionId, int reportId) {
		mapper.connectMissionAndReport(missionId, reportId);
	}

	/** 案件の日報を一覧表示
	@Override
	public Mission getMissionReportList(int missionId) {
		return mapper.findMissionReport(missionId);
	}*/

	/** 顧客を案件にアサイン */
	@Override
	public void assignCustomerToMission(int customerId, int missionId) {
		mapper.connectCustomerToMission(customerId, missionId);
	}

	/** アサインされた顧客を表示
	@Override
	public Mission getAssignedCustomer(int missionId) {
		return mapper.findAssignedCustomer(missionId);
	}*/

	/** アサインされた顧客を取り消し */
	@Override
	public void cancelCustomer(int customerId, int missionId) {
		mapper.cancelCustomerOne(customerId, missionId);
	}

	/** アサインされた従業員を取り消し */
	@Override
	public void cancelEmployee(int employeeId, int missionId) {
		mapper.cancelEmployeeOne(employeeId, missionId);
	}

	/** アサインされた従業員、顧客、日報を一覧表示 */
	@Override
	public Mission findManyRelatedTheMission(int missionId) {
		return mapper.findManyRelatedThisMission(missionId);
	}

}
