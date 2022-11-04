package com.example.demo.config;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Session implements Serializable {

    private static final long serialVersionUID = 6334063099671792256L;

    private String loginEmployeeCode;

    public String getLoginEmployeeCode(){
        return loginEmployeeCode;
    }

    public void setLoginEmployeeCode(String loginEmployeeCode) {
        this.loginEmployeeCode = loginEmployeeCode;
    }
}
