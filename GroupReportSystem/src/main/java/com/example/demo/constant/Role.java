package com.example.demo.constant;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Role {

	ADMIN("管理者", "ROLE_ADMIN"),
	GENERAL("一般", "ROLE_GENERAL");

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

	public static Map<String, String> getMapRole(){
		Map<String, String> RoleMap = new LinkedHashMap<>();
		Role admin = Role.ADMIN;
        Role general = Role.GENERAL;
        RoleMap.put(admin.getJpRoleName(), admin.getEnRoleName());
		RoleMap.put(general.getJpRoleName(), general.getEnRoleName());

		return RoleMap;
	}


}
