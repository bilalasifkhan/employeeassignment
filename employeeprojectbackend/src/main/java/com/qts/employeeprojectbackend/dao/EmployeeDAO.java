package com.qts.employeeprojectbackend.dao;

import java.util.List;

import com.qts.employeeprojectbackend.dto.Employee;

public interface EmployeeDAO {
	
	List<Employee> listAll();
	List<Employee> getEmployee(String name);
	Employee getEmployee(int id);
	void addEmployee(String name, int grade, long salary);
	boolean updateEmployee(String name, int id, int grade, long salary, boolean isActive);
	boolean promoteEmployee(int id, int grade, long salary);
	boolean deleteEmployee(int id);
	

}
