package com.qts.employeeprojectbackend.test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qts.employeeprojectbackend.dao.EmployeeDAO;
import com.qts.employeeprojectbackend.dto.Employee;

public class EmployeeTestCases {
	
	private Employee employee;
	private static EmployeeDAO employeeDAO;
	private static AnnotationConfigApplicationContext context;
	
	
	/* JUNIT PORTION */
	/*
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.qts.employeeprojectbackend");
		context.refresh();
		
		employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		
	}
	
	@Test
	public void testAddEmployee() {
		employee = new Employee();
		employee.setName("Joshua Richard");
		employee.setEmpId("EMP799523000");
		employee.setGrade(12);
		employee.setSalary(65000);
		
		assertEquals("Successfully aded employee to the table", true, employeeDAO.add(employee));
	}
	*/
	/* TESTNG PORTION */
	
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.qts.employeeprojectbackend");
		context.refresh();
		
		employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
	}
	
	/*Testing Business Logic Methods */
	
	
	//Testing CRUD Operation
	@Test
	public void testCRUDOperation() {
		
		//Adding Employee
		assertEquals(employeeDAO.addEmployee("Chris Cameron", 12, 80000), true, "Successfully added employee to the table");
		
		//Updating Employee
		assertEquals(employeeDAO.updateEmployee("Jessica Biel", "EMP4545A279D9", 20, 58000, true), true, "Successfully updated employee to the table");
		
		//Promoting Employee
		assertEquals(employeeDAO.promoteEmployee("EMP37686CF3D6", 14, 70000), true, "Successfully promoted employee to the table");
		
		//Deleting Employee
		assertEquals(employeeDAO.deleteEmployee("EMPFC5FC29675"), true, "Successfully deleted employee to the table");
		
		//List Active Users only
		List<Employee> employeeList = employeeDAO.listAll();
		assertEquals(employeeList.size(), 4, "Successfully getting active only list");
	
	}
	

}
