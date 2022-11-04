package com.example.demo.ap.controller;



import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.ap.form.LoginForm;
import com.example.demo.domain.employee.model.Employee;
import com.example.demo.domain.employee.service.EmployeeService;
import com.example.demo.domain.mission.model.Mission;



@Controller

public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private HttpSession session;



    /* ログイン画面を表示 */
    @GetMapping("/login")
    public String getLogin(@ModelAttribute LoginForm loginForm) {
        return "login/login";
    }



    /** ログインユーザーの担当案件一覧 */
    @GetMapping("/loginUserMission")
    public String getLoginedUserMission(@AuthenticationPrincipal UserDetails user, Model model) {


        String loginEmployeeCode = user.getUsername();

        /** 従業員番号から従業員情報を一件取得 */
        Employee employee = employeeService.getEmployeeDetailByCode(loginEmployeeCode);

        /** 従業員idを条件に従業員案件を取得 */
        Employee employeeMission = employeeService.getAssignedMission(employee.getEmployeeId());

        if(employeeMission != null) {
        model.addAttribute("loginEmployeeMission", employeeMission.getMissionList());
        } else {
            model.addAttribute("loginEmployeeMission", new ArrayList<Mission>());
        }

        return "topPage";
    }
}



