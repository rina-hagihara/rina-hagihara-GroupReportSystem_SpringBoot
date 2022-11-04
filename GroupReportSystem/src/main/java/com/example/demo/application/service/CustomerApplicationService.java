package com.example.demo.application.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class CustomerApplicationService {

    @Autowired
    private MessageSource messageSource;

    public Map<String, Integer> getPayState(Locale locale){
        Map<String, Integer> payState = new LinkedHashMap<>();
        String paid = messageSource.getMessage("paid", null, locale);
        String unpaid = messageSource.getMessage("unpaid", null, locale);

        payState.put(paid, 1);
        payState.put(unpaid, 2);

        return payState;
    }
}
