package com.tvtodo.models;

public enum Days {
	MONDAY("Monday"),
	TUESDAY("Tuesday"),
	WEDENSDAY("Wedensday"),
	THURSDAY("Thursday"),
	FRIDAY("Friday"),
	SATURDAY("Saturday"),
	SUNDAY("Sunday");
	
	private String str;
	
	private Days(String str){
		this.str =str;
	}

	public String getStr() {
		return str;
	}

	
}
