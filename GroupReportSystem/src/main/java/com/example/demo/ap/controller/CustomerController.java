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

import com.example.demo.ap.form.CustomerSignupForm;
import com.example.demo.ap.form.CustomerUpdateForm;
import com.example.demo.application.service.CustomerApplicationService;
import com.example.demo.domain.customer.model.Customer;
import com.example.demo.domain.customer.service.CustomerService;

import lombok.extern.slf4j.Slf4j;



@Controller
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerApplicationService customerApplicationService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    ModelMapper modelMapper;



    /** 顧客新規登録 */

    @GetMapping("/signup")
    public String  getCustomerSignup(Locale locale, Model model, @ModelAttribute CustomerSignupForm form) {

    	Map<String, Integer> payStateMap = customerApplicationService.getPayState();

    	model.addAttribute("payStateMap", payStateMap);
        return "customer/signup";

    }

    @PostMapping("/signup")
    public String postCustomerSignup(Locale locale, Model model,
            @ModelAttribute @Validated CustomerSignupForm form, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            getCustomerSignup(locale, model, form);
        }

        log.info(form.toString());
        Customer customer = modelMapper.map(form, Customer.class);
        customerService.insertCustomer(customer);

        return "redirect:/customer/list";
    }

    /** 顧客一覧表示 */

    @GetMapping("/list")
    public String getCustomerList(Model model) {
        List<Customer> customer = customerService.getCustomerList();
        model.addAttribute("customer", customer);
        return "customer/list";
    }

    /** 顧客詳細表示 */

    @GetMapping("/detail/{customerId}")
    public String getCustomerDetail(@PathVariable int customerId, Model model) {
        Customer customer = customerService.getCustomerDetail(customerId);
        model.addAttribute("customer", customer);
        return "customer/detail";
    }

    /** 顧客更新 */


    @GetMapping("/update/{customerId}")
    public String getCustomerUpdate(@PathVariable("customerId")int customerId, @ModelAttribute CustomerUpdateForm customerUpdateForm,
            Model model, Locale locale) {

        if(customerUpdateForm.getCustomerCode() == null) {

        Customer customer = customerService.getCustomerDetail(customerId);
        customerUpdateForm = modelMapper.map(customer, CustomerUpdateForm.class);
        model.addAttribute("customerUpdateForm", customerUpdateForm);

        }

        log.info("customerUpdateForm.toString : " + customerUpdateForm.toString());
        model.addAttribute("payStateMap", customerApplicationService.getPayState());
        return "customer/update";
    }

    @PostMapping("/update/{customerId}")
    public String postCustomerUpdate(@PathVariable("customerId") int customerId,
            @ModelAttribute @Validated CustomerUpdateForm customerUpdateForm, BindingResult bindingResult,
            Model model, Locale locale) {

        if(bindingResult.hasErrors()) {
            getCustomerUpdate(customerId, customerUpdateForm, model, locale);
        }

        Customer customer = modelMapper.map(customerUpdateForm, Customer.class);
        customerService.updateCustomer(customer);
        return "redirect:/customer/list";
    }

    /** 顧客削除 */
    @PostMapping("/delete/{customerId}")
    String deleteCustomer(@PathVariable("customerId")int customerId) {
        customerService.deleteCustomer(customerId);
        return "customer/list";
    }



}
