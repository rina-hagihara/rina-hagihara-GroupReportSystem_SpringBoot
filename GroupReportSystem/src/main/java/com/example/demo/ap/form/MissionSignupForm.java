package com.example.demo.ap.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MissionSignupForm {

	@NotBlank(groups = ValidGroup1.class)
	private String missionTitle;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date visitDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date moveDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date payDue;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String note;
}
