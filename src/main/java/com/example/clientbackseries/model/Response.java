package com.example.clientbackseries.model;

public class Response {
	
	private int code;
	private String description;
	
	public Response() {
	}
	
	public Response(int code, String description) {
		super();
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
