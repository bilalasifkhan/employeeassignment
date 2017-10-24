package com.qts.employeeprojectbackend.dto;

public class Employee {
	
	/*
	 * Private fields
	 */
	
	private int id;
	private String name;
	private long salary;
	private int grade;
	private boolean isActive;
	
	/*
	 * Getter and Setter Methods
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setSalary(long salary) {
		this.salary=salary;
	}
	
	public void setGrade(int grade) {
		this.grade=grade;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive=isActive;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public long getSalary() {
		return salary;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public boolean getIsActive() {
		return isActive;
	}

}
