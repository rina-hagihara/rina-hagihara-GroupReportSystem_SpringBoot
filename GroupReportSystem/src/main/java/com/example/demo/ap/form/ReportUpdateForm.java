package com.example.demo.ap.form;

import lombok.Data;

@Data
public class ReportUpdateForm {

	private int reportId;

	private String reportTitle;

	private String employeeName;

	private String content;
}
