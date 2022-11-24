package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.mission.model.Mission;

@Mapper
public interface MissionMapper {

	/** 案件新規登録 */
	public void insertOne(Mission mission);

	/** 案件一覧取得 */
	public List<Mission> findMany();

	/** 案件詳細表示 */
	public Mission findOne(int missionId);

	/** 案件更新 */
	public void updateOne(Mission mission);

	/** 案件削除 */
	public void deleteOne(int missionId);

	/** 従業員アサイン */
	public void joinEmployeeToMission(int employeeId, int missionId);

	/** 案件IDをもとに案件担当従業員を表示 */
	public Mission findAssignedOne(int missionId);

	/** 日報と案件をコネクト */
	public void connectMissionAndReport(int missionId, int reportId);

	/** 案件の日報を一覧表示 */
	public Mission findMissionReport(int missionId);

	/** 顧客を案件にアサイン */
	public void connectCustomerToMission(int customerId, int missionId);

	/** アサインされた顧客を一覧表示 */
	public Mission findAssignedCustomer(int missionId);

	/** アサインされた顧客をキャンセル */
	public void cancelCustomerOne(int customerId, int missionId);

	/** アサインされた従業員をキャンセル */
	public void cancelEmployeeOne(int employeeId, int missionId);

}