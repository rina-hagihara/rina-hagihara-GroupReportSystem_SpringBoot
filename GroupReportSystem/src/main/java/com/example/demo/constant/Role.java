package com.example.demo.constant;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Role {

	ADMIN("管理者", "ROLE_ADMIN"), GENERAL("一般", "ROLE_GENERAL");

	public final String JpRoleName;
	public final String EnRoleName;

	private Role(final String JpRoleName, final String EnRoleName) {
		this.JpRoleName = JpRoleName;
		this.EnRoleName = EnRoleName;
	}

	public String getJpRoleName() {
		return this.JpRoleName;
	}

	public String getEnRoleName() {
		return this.EnRoleName;
	}

	public static Map<String, String> getMapRole() {

		return Stream.of(Role.values()).collect(Collectors
				.toMap(e -> e.getJpRoleName(), e -> e.getEnRoleName()));
	}

}
