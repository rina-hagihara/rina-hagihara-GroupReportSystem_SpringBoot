package com.example.demo.application.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.constant.PayState;



@Service
public class CustomerApplicationService {



    /*public Map<String, Integer> getPayState(Locale locale){
        Map<String, Integer> payState = new LinkedHashMap<>();
        String paid = messageSource.getMessage("paid", null, locale);
        String unpaid = messageSource.getMessage("unpaid", null, locale);

        payState.put(paid, 1);
        payState.put(unpaid, 2);

        return payState;
    }*/

	public Map<String, Integer> getPayState(){

		Map<String, Integer> payStates = new LinkedHashMap<>();
		PayState paid = PayState.PAID;
		payStates.put(paid.getState(), paid.getCode());

		PayState unpaid = PayState.UNPAID;
		payStates.put(unpaid.getState(), unpaid.getCode());

		return payStates;
	}
}
