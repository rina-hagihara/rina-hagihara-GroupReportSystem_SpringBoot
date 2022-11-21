package com.example.demo.constant;

import java.util.LinkedHashMap;
import java.util.Map;

public enum PayState {

	PAID("支払い済み", 1),
	UNPAID("未払い", 2);

	public final String state;
	public final Integer code;

	private PayState(final String state, final Integer code) {

		this.state = state;
		this.code = code;

	}

	public String getState() {
		return this.state;
	}

	public Integer getCode() {
		return this.code;
	}

	public static Map<String, Integer> getPayState(){

		Map<String, Integer> payStates = new LinkedHashMap<>();
		PayState paid = PayState.PAID;
		payStates.put(paid.getState(), paid.getCode());

		PayState unpaid = PayState.UNPAID;
		payStates.put(unpaid.getState(), unpaid.getCode());

		return payStates;
	}


}
