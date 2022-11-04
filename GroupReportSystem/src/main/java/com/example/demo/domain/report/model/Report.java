package com.example.demo.domain.report.model;

import lombok.Data;

@Data
public class Report {

    private int reportId;

    private String reportCode;

    private String reportTitle;

    private String employeeName;

    private String content;
}
