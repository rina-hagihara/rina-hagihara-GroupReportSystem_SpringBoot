package com.example.demo.ap.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EmployeeUpdateForm {
	private int employeeId;

	@NotBlank(groups = ValidGroup1.class)
	private String employeeCode;

	private String password;

	@NotBlank(groups = ValidGroup1.class)
	private String employeeName;

	@NotNull(groups = ValidGroup1.class)
	private String role;
}
