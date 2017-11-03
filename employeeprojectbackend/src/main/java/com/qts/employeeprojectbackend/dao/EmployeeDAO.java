package com.qts.employeeprojectbackend.dao;

import java.util.List;

import com.qts.employeeprojectbackend.dto.Employee;

public interface EmployeeDAO {
	
	List<Employee> listAll();
	List<Employee> getEmployee(String name);
	Employee getEmployeeById(String empId);
	boolean addEmployee(String name, int grade, long salary);
	//boolean add(Employee employee);
	boolean updateEmployee(String name, String empId, int grade, long salary, boolean isActive);
	boolean promoteEmployee(String empId, int grade, long salary);
	boolean deleteEmployee(String empId);
	
	

}
