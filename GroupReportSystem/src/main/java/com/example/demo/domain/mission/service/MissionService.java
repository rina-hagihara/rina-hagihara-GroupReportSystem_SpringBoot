package com.example.demo.domain.mission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.mission.model.Mission;

@Service
public interface MissionService {

	/** 案件1件登録 */
	public void insertMission(Mission mission);

	/** 案件一覧取得 */
	public List<Mission> getMissionList();

	/** 案件1件取得 */
	public Mission getMissionDetail(int missionId);

	/** 案件1件更新 */
	public void updateMission(Mission mission);

	/** 案件削除 */
	public void deleteMission(int missionId);

	/** 従業員アサイン */
	public void assignEmployeeToMission(int employeeId, int missionId);

	/** アサインされた従業員を表示
	public Mission getAssignedEmployee(int missionId);*/

	/** 日報と案件をコネクト */
	public void connectMissionToReport(int missionId, int reportId);

	/** 案件の日報を一覧表示
	public Mission getMissionReportList(int missionId);*/

	/** 顧客を案件にアサイン */
	public void assignCustomerToMission(int customerId, int missionId);

	/** アサインされた顧客を表示
	public Mission getAssignedCustomer(int missionId);*/

	/** アサインされた顧客を取り消し */
	public void cancelCustomer(int customerId, int missionId);

	/** アサインされた従業員を取り消し */
	public void cancelEmployee(int employeeId, int missionId);

	/** アサインされた従業員、顧客、日報を一覧表示 */
	public Mission findManyRelatedTheMission(int missionId);

}
