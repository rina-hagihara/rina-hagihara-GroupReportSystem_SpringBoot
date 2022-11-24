package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.employee.model.Employee;

@Mapper
public interface EmployeeMapper {

	/** 従業員登録 */
	public int insertOne(Employee employee);

	/** 同じ従業員コードが登録されてないか確認 */
	public Employee findSameCode(String employeeCode);

	/** 従業員一覧取得 */
	public List<Employee> findMany(Employee employee);

	/** 従業員詳細表示 */
	public Employee findOne(int employeeId);

	/** 従業員更新 */
	public void updateOne(Employee employee);

	/** 従業員削除 */
	public void deleteOne(@Param("employeeId") int employeeId);

	/** ログイン中の従業員を取得 */
	public Employee findLoginEmployee(String employeeCode);

	/** 従業員番号により従業員情報1件取得 */
	public Employee findEmployeeDetailByCode(String employeeCode);

	/** ログイン中の従業員の担当案件 */
	public Employee findAssignedMission(int employeeCode);
}
