package com.qts.employeeprojectbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.qts.employeeprojectbackend.daoimpl.HRUtilRandomizer;


@Entity
public class Employee {
	
	/*
	 * Private fields
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="emp_id")
	private String empId;
	private String name;
	private long salary;
	private int grade;
	@Column(name="is_active")
	private boolean isActive;
	
	/*
	 * Default Constructor
	 */
	
	public Employee() {
		this.empId = HRUtilRandomizer.getEmployeeID();
	}
	
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

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empId=" + empId + ", name=" + name + ", salary=" + salary + ", grade=" + grade
				+ ", isActive=" + isActive + "]";
	}
	
	

}
