package com.example.demo.ap.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.ap.form.MissionSignupForm;
import com.example.demo.ap.form.MissionUpdateForm;
import com.example.demo.domain.customer.model.Customer;
import com.example.demo.domain.customer.service.CustomerService;
import com.example.demo.domain.employee.model.Employee;
import com.example.demo.domain.employee.service.EmployeeService;
import com.example.demo.domain.mission.model.Mission;
import com.example.demo.domain.mission.service.MissionService;
import com.example.demo.domain.report.model.Report;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/mission")
@Slf4j
public class MissionController {

	@Autowired
	MissionService missionService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	CustomerService customerService;

	@Autowired
	ModelMapper modelMapper;

	/** 案件新規登録 */

	@GetMapping("/signup")
	public String getMissionSignup(@ModelAttribute MissionSignupForm form) {
		return "mission/signup";
	}

	@PostMapping("/signup")
	public String postMissionSignup(@ModelAttribute @Validated MissionSignupForm form,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			getMissionSignup(form);
		}

		log.info(form.toString());

		Mission mission = modelMapper.map(form, Mission.class);
		missionService.insertMission(mission);

		return "redirect:/mission/list";
	}

	/** 案件一覧表示 */
	@GetMapping("/list")
	public String getMissionList(Model model) {

		List<Mission> mission = missionService.getMissionList();
		model.addAttribute("mission", mission);

		return "mission/list";
	}

	/** 案件詳細表示 */
	@GetMapping("/detail/{missionId}")
	public String getDetail(@PathVariable("missionId") int missionId, Model model) {

		Mission mission = missionService.getMissionDetail(missionId);
		model.addAttribute("mission", mission);

		/** 案件にアサインした従業員を表示
		Mission assignedEmployee = missionService.getAssignedEmployee(missionId);
		if (assignedEmployee != null) {
			model.addAttribute("assignedEmployeeList", assignedEmployee.getEmployeeList());
		} else {
			//nullの場合空のリストを設定
			model.addAttribute("assignedEmployee", new ArrayList<Employee>());
		}*/

		/** 案件の日報一覧を表示
		Mission missionReport = missionService.getMissionReportList(missionId);

		if (missionReport != null) {
			model.addAttribute("missionReportList", missionReport.getReportList());
		} else {
			model.addAttribute("missionReportList", new ArrayList<Report>());
		}*/

		/** アサインした顧客を一覧表示
		Mission assignedCustomer = missionService.getAssignedCustomer(missionId);
		if (assignedCustomer != null) {
			model.addAttribute("assignedCustomerList", assignedCustomer.getCustomerList());
		} else {
			model.addAttribute("assignedCustomerList", new ArrayList<Customer>());
		}*/

		/** 案件にアサインされた従業員、顧客、日報を一覧表示 */
		Mission assignedOne = missionService.findManyRelatedTheMission(missionId);
		if(assignedOne != null) {
		model.addAttribute("assignedCustomerList", assignedOne.getCustomerList());
		model.addAttribute("missionReportList", assignedOne.getReportList());
		model.addAttribute("assignedEmployeeList", assignedOne.getEmployeeList());
		} else {
			model.addAttribute("assignedCustomerList", new ArrayList<Customer>());
			model.addAttribute("missionReportList", new ArrayList<Report>());
			model.addAttribute("assignedEmployeeList", new ArrayList<Employee>());
		}

		return "mission/detail";
	}

	/** 案件更新 */
	@GetMapping("/update/{missionId}")
	String getMissionUpdate(@PathVariable("missionId") int missionId,
			@ModelAttribute MissionUpdateForm missionUpdateForm,
			Model model) {

		if (missionUpdateForm.getMissionTitle() == null) {
			Mission mission = missionService.getMissionDetail(missionId);
			missionUpdateForm = modelMapper.map(mission, MissionUpdateForm.class);
			model.addAttribute("missionUpdateForm", missionUpdateForm);
		}

		log.info("missionUpdateForm.toString : " + missionUpdateForm.toString());
		return "mission/update";
	}

	@PostMapping("/update/{missionId}")
	String postMissionUpdate(@PathVariable("missionId") int missionId,
			@ModelAttribute @Validated MissionUpdateForm missionUpdateForm,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			getMissionUpdate(missionId, missionUpdateForm, model);
		}

		log.info("missionUpdateForm.toString : " + missionUpdateForm.toString());
		Mission mission = modelMapper.map(missionUpdateForm, Mission.class);
		missionService.updateMission(mission);

		return "redirect:/mission/list";
	}

	/** 案件削除 */
	@PostMapping("/delete/{missionId}")
	public String deleteMission(@PathVariable("missionId") int missionId) {
		missionService.deleteMission(missionId);

		return "redirect:/mission/list";
	}

	/** 従業員アサインページを表示 */
	@GetMapping("/employeeAssign/{missionId}")
	public String getMissionAssign(@PathVariable("missionId") int missionId, Model model,
			Employee employee) {
		List<Employee> employeeList = employeeService.getEmployeeList(employee);
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("missionId", missionId);
		return "mission/employeeAssign";
	}

	/** 案件に従業員をアサイン */
	@PostMapping("/assign/{employeeId}/{missionId}")
	public String postMissionAssign(@PathVariable("employeeId") int employeeId,
			@PathVariable("missionId") int missionId) {

		missionService.assignEmployeeToMission(employeeId, missionId);

		return "redirect:/mission/detail/{missionId}";
	}

	/** 顧客アサインページを表示 */
	@GetMapping("/assignCustomer/{missionId}")
	public String getCustomerAssignPage(@PathVariable("missionId") int missionId, Model model) {

		List<Customer> customerList = customerService.getCustomerList();
		model.addAttribute("customerList", customerList);

		model.addAttribute("missionId", missionId);

		return "mission/customerAssign";
	}

	/** 案件に顧客をアサイン */
	@PostMapping("/assignCustomer/{customerId}/{missionId}")
	public String postAssignCustomer(@PathVariable("customerId") int customerId,
			@PathVariable("missionId") int missionId) {

		missionService.assignCustomerToMission(customerId, missionId);

		return "redirect:/mission/detail/{missionId}";
	}

	/** アサインした顧客を取り消す */
	@PostMapping("/cancelCustomer/{customerId}/{missionId}")
	public String cancelCustomer(@PathVariable("customerId") int customerId,
			@PathVariable("missionId") int missionId) {

		missionService.cancelCustomer(customerId, missionId);
		return "redirect:/mission/detail/{missionId}";
	}

	/** アサインした従業員を取り消す */
	@PostMapping("/cancelEmployee/{employeeId}/{missionId}")
	public String cancelEmployee(@PathVariable("employeeId") int employeeId,
			@PathVariable("missionId") int missionId) {

		missionService.cancelEmployee(employeeId, missionId);
		return "redirect:/mission/detail/{missionId}";
	}

}
