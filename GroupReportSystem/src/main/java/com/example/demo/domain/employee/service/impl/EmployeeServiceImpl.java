package com.example.demo.domain.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.employee.model.Employee;
import com.example.demo.domain.employee.service.EmployeeService;
import com.example.demo.repository.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeMapper mapper;

	@Autowired
	private PasswordEncoder encoder;

	/** 従業員登録 */
	@Override
	public void signup(Employee employee) {
		//パスワード暗号化
		String rawPassword = employee.getPassword();
		employee.setPassword(encoder.encode(rawPassword));
		mapper.insertOne(employee);
	}

	/** 同じ従業員コードが登録されてないか確認 */
	@Override
	public Employee findSameEmployeeCode(String employeeCode) {
		return mapper.findSameCode(employeeCode);
	}

	/** 従業員一覧取得 */
	@Override
	public List<Employee> getEmployeeList(Employee employee) {
		return mapper.findMany(employee);
	}

	/** 従業員1件取得 */
	@Override
	public Employee getEmployeeDetail(int employeeId) {
		return mapper.findOne(employeeId);
	}

	/** 従業員1件更新 */
	@Override
	public void updateEmployee(Employee employee) {
		//パスワード暗号化
		String rawPassword = employee.getPassword();
		String encryptPassword = encoder.encode(rawPassword);
		employee.setPassword(encryptPassword);

		mapper.updateOne(employee);
	}

	/** 従業員1検削除 */
	@Override
	public void deleteEmployee(int employeeId) {
		mapper.deleteOne(employeeId);
	}

	/** 従業員番号により従業員情報1件取得 */
	@Override
	public Employee getEmployeeDetailByCode(String employeeCode) {
		return mapper.findEmployeeDetailByCode(employeeCode);
	}

	/** ログイン中の従業員の担当案件を表示 */
	@Override
	public Employee getAssignedMission(int employeeId) {
		return mapper.findAssignedMission(employeeId);
	}

}
