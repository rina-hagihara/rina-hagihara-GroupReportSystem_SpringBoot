package com.example.demo.ap.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class EmployeeSignupForm {

	private int employeeId;

	@NotBlank(groups = ValidGroup1.class)
	private String employeeCode;

	@NotBlank(groups = ValidGroup1.class)
	private String employeeName;

	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 4, max = 100, groups = ValidGroup2.class)
	@Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup2.class)
	private String password;

	@NotNull(groups = ValidGroup1.class)
	private String role;
}
