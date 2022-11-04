package com.example.demo.domain.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.domain.employee.model.Employee;
import com.example.demo.domain.employee.service.EmployeeService;

@Service

public class EmployeeDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String employeeCode)throws UsernameNotFoundException{

        //従業員情報取得
        Employee loginEmployee = employeeService.getEmployeeDetailByCode(employeeCode);

        //ユーザーが存在しない場合
        if(loginEmployee == null) {
            throw new UsernameNotFoundException("user not found");
        }

        //権限List作成
        GrantedAuthority authority = new SimpleGrantedAuthority(loginEmployee.getRole());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);

        //UserDetails作成
        UserDetails userDetails = (UserDetails) new User(loginEmployee.getEmployeeCode(),
                loginEmployee.getPassword(), authorities);

        return userDetails;




    }

}
