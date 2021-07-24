package com.me.common.enums;

public enum RoleEnum {
	ROLE_ADMIN(1),
	ROLE_SELLER(2),
	ROLE_CUSTOMER(3);
	
	public int value;
	
	private RoleEnum(int value) {
		this.value = value;
	}
	
}
