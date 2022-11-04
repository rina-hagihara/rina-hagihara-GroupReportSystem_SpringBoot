package com.example.demo.ap.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

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

import com.example.demo.ap.form.EmployeeListForm;
import com.example.demo.ap.form.EmployeeSignupForm;
import com.example.demo.ap.form.EmployeeUpdateForm;
import com.example.demo.ap.form.GroupOrder;
import com.example.demo.application.service.EmployeeApplicationService;
import com.example.demo.domain.employee.model.Employee;
import com.example.demo.domain.employee.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {



    @Autowired
    private EmployeeApplicationService employeeApplicationService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeService employeeService;





    /** 従業員新規登録 */

    /** ユーザー登録画面を表示 */
    @GetMapping("/signup")
    public String getSignupEmployee(Model model, Locale locale,
            @ModelAttribute EmployeeSignupForm form){
        Map<String, String> roleMap = employeeApplicationService.getRole(locale);
        model.addAttribute("roleMap", roleMap);
        return "employee/signup";
    }

    /** 従業員登録処理 */
    @PostMapping("/signup")
    //従業員一覧にリダイレクト
    public String postSignupEmployee(Model model, Locale locale, @ModelAttribute
            @Validated(GroupOrder.class) EmployeeSignupForm form,
            BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return getSignupEmployee(model, locale, form);
        }

        /** 既に登録済みの従業員コードがないか検索 */
        Employee sameCodeEmployee = employeeService.findSameEmployeeCode(form.getEmployeeCode());

        if(sameCodeEmployee != null) {
            model.addAttribute("message", "既に同じ従業員番号が登録されています");
            return getSignupEmployee(model, locale, form);
        }



        log.info(form.toString());

        Employee employee = modelMapper.map(form, Employee.class);
        employeeService.signup(employee);

        return "redirect:/employee/list";
    }

    /** 従業員一覧表示 *
     *
     */
    /** 従業員一覧*/
    @GetMapping("/list")
    public String getEmployeeList(@ModelAttribute EmployeeListForm form, Model model) {

        Employee employee = modelMapper.map(form, Employee.class);

        List<Employee> employeeList = employeeService.getEmployeeList(employee);
        model.addAttribute("employeeList", employeeList);
        return "employee/list";
    }

    /** ユーザー検索処理 */
    @PostMapping("/list")
    public String postEmployeeList(@ModelAttribute EmployeeListForm form, Model model) {

        Employee employee = modelMapper.map(form, Employee.class);

        List<Employee> employeeList = employeeService. getEmployeeList(employee);
        model.addAttribute("employeeList", employeeList);

        return "employee/list";
    }





    /** 従業員詳細 */

    /** 従業員詳細を表示 */
    @GetMapping("/detail/{employeeId}")
    public String getDetail(@PathVariable("employeeId")int employeeId, Model model) {
        Employee employee = employeeService.getEmployeeDetail(employeeId);
        model.addAttribute("employee", employee);

        return "employee/detail";
    }

    /** 従業員更新 */
    @GetMapping("/update/{employeeId}")
    public String getUpdate(@PathVariable("employeeId") int employeeId, @ModelAttribute EmployeeUpdateForm employeeUpdateForm,
            Model model, Locale locale) {

        if(employeeUpdateForm.getEmployeeCode() == null) {
            Employee employee = employeeService.getEmployeeDetail(employeeId);
            employeeUpdateForm = modelMapper.map(employee, EmployeeUpdateForm.class);
            model.addAttribute("employeeUpdateForm", employeeUpdateForm);
        }

        log.info("employeeUpdate.toString : " + employeeUpdateForm.toString());
        model.addAttribute("roleMap", employeeApplicationService.getRole(locale));

        return "employee/update";
    }

    /** 従業員更新 */
    @PostMapping("/update/{employeeId}")
    public String postUpdate(@PathVariable("employeeId")int employeeId, @ModelAttribute @Validated(GroupOrder.class)
    EmployeeUpdateForm employeeUpdateForm, BindingResult bindingResult, Model model, Locale locale){

        if(bindingResult.hasErrors()) {
            return getUpdate(employeeId, employeeUpdateForm, model, locale);
        }

        log.info("employeeUpdateForm.toString : " + employeeUpdateForm.toString());

        Employee employee = modelMapper.map(employeeUpdateForm, Employee.class);
        employeeService.updateEmployee(employee);

        return "redirect:/employee/list";

    }



    /** 従業員削除 */

    @PostMapping("/delete/{employeeId}")
    public String postDelete(@PathVariable("employeeId")int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employee/list";
    }




}
