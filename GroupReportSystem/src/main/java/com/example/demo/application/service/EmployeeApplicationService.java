package com.example.demo.application.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class EmployeeApplicationService {

    @Autowired
    private MessageSource messageSource;

    public Map<String, String> getRole(Locale locale){
        Map<String, String> roleMap = new LinkedHashMap<>();
        String admin = messageSource.getMessage("admin", null, locale);
        String general = messageSource.getMessage("general", null, locale);
        roleMap.put(admin, "ROLE_ADMIN");
        roleMap.put(general, "ROLE_GENERAL");
        return roleMap;
    }
}
