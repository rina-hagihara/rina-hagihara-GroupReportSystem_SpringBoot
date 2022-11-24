package com.example.demo.domain.mission.model;

import java.util.Date;
import java.util.List;

import com.example.demo.domain.customer.model.Customer;
import com.example.demo.domain.employee.model.Employee;
import com.example.demo.domain.report.model.Report;

import lombok.Data;

@Data
public class Mission {

	private int missionId;

	private String missionTitle;

	private Date visitDate;

	private Date moveDate;

	private Date payDue;

	private String note;

	private List<Employee> employeeList;

	private List<Report> reportList;

	private List<Customer> customerList;
}
