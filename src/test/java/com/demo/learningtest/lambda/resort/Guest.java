package com.demo.learningtest.lambda.resort;

public class Guest {
	private int grade;
	private String name;
	private String company;
	
	public Guest() {}
	
	public Guest(int grade, String name, String company) {
		this.grade = grade;
		this.name = name;
		this.company = company;
	}
	
	public int getGrade() {
		return this.grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}
