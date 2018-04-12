package com.tvtodo.constants;

public enum LoginEnum {
	LOGIN_SUCCESS("login success"),
	LOGIN_FAIL("username or password not correct"),
	USER_NOT_EXIST("user not exist");
	
	private final String info;
	
	
	 LoginEnum(String info){
		this.info =info;
	 }


	public String getInfo() {
		return info;
	}
}