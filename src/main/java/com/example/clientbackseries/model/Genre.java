package com.example.clientbackseries.model;

public class Genre {
	
	private int code;
	private String name;
	
	public Genre() {
		super();
	}
	
	public Genre(int code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
