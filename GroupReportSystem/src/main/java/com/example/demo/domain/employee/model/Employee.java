package com.example.demo.domain.employee.model;

import java.util.List;

import com.example.demo.domain.mission.model.Mission;

import lombok.Data;

@Data
public class Employee {
	private int employeeId;

	private String employeeCode;

	private String employeeName;

	private String password;

	private String role;

	private List<Mission> missionList;
}
