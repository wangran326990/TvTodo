package com.tvtodo.dto;

public class AjaxResponse <T> {
	private T response;
	private String errorMessage;
	
	public AjaxResponse(){
		
	}
	
	public AjaxResponse(T response, String errorMessage) {
		super();
		this.response = response;
		this.errorMessage = errorMessage;
	}
	
	
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
