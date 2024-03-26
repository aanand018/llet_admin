package com.snipe.let.admin.constants;

import java.util.HashMap;
import java.util.Map;

public enum Role {

	TIEUPS("1"), ADMIN("2"), RETAILER("3"), CUSTOMER("4"), COLLECTION_CENTER("5"), DOCTOR("6"), 
	OPERATIONAL_TEAM("7"),LABOUR("8"), FARMER("9"), EMPLOYEE("10"), WHOLESALER("11"), 
	WHOLEBUYER("12"), WAREHOUSE("13"), MANAGER("15"), EXECUTIVE("16"), SUPPLIER("17");

	private static Map<String, Role> codeToRoleMapping;
	private String code;

	private Role(String c) {
		code = c;
	}

	public String getCode() {
		return code;
	}

	public static Role getRole(String roleId) {
		if (codeToRoleMapping == null) {
			initMapping();
		}
		return codeToRoleMapping.get(roleId);
	}

	private static void initMapping() {
		codeToRoleMapping = new HashMap<String, Role>();
		for (Role s : values()) {
			codeToRoleMapping.put(s.code, s);
		}
	}

}
