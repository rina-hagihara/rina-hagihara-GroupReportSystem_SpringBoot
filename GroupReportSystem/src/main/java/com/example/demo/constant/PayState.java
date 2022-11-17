package com.example.demo.constant;

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


}
