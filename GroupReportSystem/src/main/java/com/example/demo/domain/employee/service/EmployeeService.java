package com.example.demo.domain.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.employee.model.Employee;

@Service
public interface EmployeeService {

	/** 従業員登録 */
	public void signup(Employee employee);

	/** 同じ従業員コードが登録されてないか確認 */
	public Employee findSameEmployeeCode(String employeeCode);

	/** 従業員一覧取得 */
	public List<Employee> getEmployeeList(Employee employee);

	/** 従業員1件取得 */
	public Employee getEmployeeDetail(int employeeId);

	/** 従業員1件更新 */
	public void updateEmployee(Employee employee);

	/** 従業員1件削除 */
	public void deleteEmployee(int employeeId);

	/** 従業員番号により従業員情報1件取得 */
	public Employee getEmployeeDetailByCode(String employeeCode);

	/** ログイン中の従業員の担当案件を表示 */
	public Employee getAssignedMission(int employeeId);
}
