package com.qts.employeeprojectbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.qts.employeeprojectbackend.dao.EmployeeDAO;
import com.qts.employeeprojectbackend.dto.Employee;


@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	//Static list of Employees
	private static List<Employee> employeeList = new ArrayList<>();
	
	//Initializing a static list
	static {
		
		//Adding first employee
		Employee employee1 = new Employee();
		employee1.setIsActive(true);
		employee1.setName("John Doe");
		employee1.setSalary(40000);
		employee1.setGrade(5);
		employee1.setId(HRUtilRandomizer.getEmployeeID());
		
		employeeList.add(employee1);
		
		//Adding more employees
		employee1 = new Employee();
		employee1.setIsActive(true);
		employee1.setName("Mary Smith");
		employee1.setSalary(40000);
		employee1.setGrade(5);
		employee1.setId(HRUtilRandomizer.getEmployeeID());
		
		employeeList.add(employee1);
		
		employee1 = new Employee();
		employee1.setIsActive(true);
		employee1.setName("Tony Stark");
		employee1.setSalary(70000);
		employee1.setGrade(3);
		employee1.setId(HRUtilRandomizer.getEmployeeID());
		
		employeeList.add(employee1);
		
		
		
		
	}
	
	@Override
	public List<Employee> listAll() {
		List<Employee> activeOnlyEmployeeList = new ArrayList<>();
		Employee e = new Employee();
		for(int i = 0; i<employeeList.size();i++) {
			e=employeeList.get(i);
			if(e.getIsActive()==true) {
				activeOnlyEmployeeList.add(e);
			}
		}
		
		return activeOnlyEmployeeList;
	}
	
	public List<Employee> listAllEmp() {
		return employeeList;
	}

	/**
	 * Find Employee by name and return list of employees with matching names
	 */
	@Override
	public List<Employee> getEmployee(String name) {
		Employee emp = new Employee();
		List<Employee> empList = new ArrayList<>();
		for(int i=0; i<employeeList.size(); i++) {
			emp=employeeList.get(i);
			if(emp.getName().compareToIgnoreCase(name) == 0) {
				empList.add(emp);
			}
		}
		return empList;
	}

	@Override
	public Employee getEmployee(int id) {
		Employee emp = new Employee();
		for(int i=0; i<employeeList.size(); i++) {
			emp=employeeList.get(i);
			if(emp.getId()==id) {
				return emp;
			}
		}
		return null;
	}


	@Override
	public boolean deleteEmployee(int id) {
		Employee e = getEmployee(id);
		if(e!=null) {
			e.setIsActive(false);
			return true;
		}
		
		return false;
		
	}

	@Override
	public void addEmployee(String name, int grade, long salary) {
		Employee emp = new Employee();
		emp.setName(name);emp.setIsActive(true);emp.setGrade(grade);emp.setSalary(salary);
		emp.setId(HRUtilRandomizer.getEmployeeID());
		employeeList.add(emp);
		
	}

	@Override
	public boolean updateEmployee(String name, int id, int grade, long salary, boolean isActive) {
		Employee e1 = getEmployee(id);
		if(e1!=null) {
			e1.setName(name);
			e1.setGrade(grade);
			e1.setSalary(salary);
			e1.setIsActive(isActive);
			swapEmployee(e1);
			return true;
		}
		return false;
		
	}
	
	@Override
	public boolean promoteEmployee(int id, int grade, long salary) {
		Employee e = getEmployee(id);
		if(e!=null) {
			e.setGrade(grade);
			e.setSalary(salary);
			swapEmployee(e);
			return true;
		}
		return false;
	}
	
	
	/* Private Methods */
	public void swapEmployee(Employee newEmployee) {
		
		Employee e = new Employee();
		for(int i=0; i<employeeList.size(); i++) {
			e=employeeList.get(i);
			if(newEmployee.getId()==e.getId()) {
				employeeList.remove(i);
				e.setId(newEmployee.getId());
				e.setName(newEmployee.getName());
				e.setGrade(newEmployee.getGrade());
				e.setSalary(newEmployee.getSalary());
				e.setIsActive(newEmployee.getIsActive());
				employeeList.add(e);
			}
		}
	}



}
