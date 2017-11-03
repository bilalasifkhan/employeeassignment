package com.qts.employeeprojectbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qts.employeeprojectbackend.dao.EmployeeDAO;
import com.qts.employeeprojectbackend.dto.Employee;

@Repository("employeeDAO")
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {


	@Autowired
	private SessionFactory sessionFactory;

	
	//List Active Only Employees
	@Override
	public List<Employee> listAll() {

		// retrieve the whole list
		List<Employee> employeeList = sessionFactory.getCurrentSession()
				.createQuery("select (e) from Employee e", Employee.class).list();

		// Active Only list
		List<Employee> activeOnlyEmployeeList = new ArrayList<>();
		Employee e = new Employee();
		for (int i = 0; i < employeeList.size(); i++) {
			e = employeeList.get(i);
			if (e.getIsActive() == true) {
				activeOnlyEmployeeList.add(e);
			}
		}

		return activeOnlyEmployeeList;
	}

	//List all employees
	public List<Employee> listAllEmp() {
		// retrieve the whole list
		List<Employee> employeeList = sessionFactory.getCurrentSession()
				.createQuery("select (e) from Employee e", Employee.class).list();
		return employeeList;
	}

	/**
	 * Find Employee by name and return list of employees with matching names
	 */
	@Override
	public List<Employee> getEmployee(String name) {
		Employee emp = new Employee();

		// retrieve the whole list
		List<Employee> employeeList = sessionFactory.getCurrentSession()
				.createQuery("select (e) from Employee e", Employee.class).list();

		// List of employees with names = name;
		List<Employee> empList = new ArrayList<>();
		for (int i = 0; i < employeeList.size(); i++) {
			emp = employeeList.get(i);
			if (emp.getName().compareToIgnoreCase(name) == 0) {
				empList.add(emp);
			}
		}
		return empList;
	}

	@Override
	public Employee getEmployeeById(String empId) {
		// retrieve the whole list
		List<Employee> employeeList = sessionFactory.getCurrentSession()
				.createQuery("select (e) from Employee e", Employee.class).list();

		Employee emp = new Employee();

		for (int i = 0; i < employeeList.size(); i++) {
			emp = employeeList.get(i);
			if (emp.getEmpId().compareToIgnoreCase(empId) == 0) {
				return emp;
			}
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(String empId) {

		Employee e = getEmployeeById(empId);
		if (e != null) {
			e.setIsActive(false);
			update(e);
			return true;
		}

		return false;

	}

	@Override
	public boolean addEmployee(String name, int grade, long salary) {
		Employee emp = new Employee();
		emp.setName(name);
		emp.setIsActive(true);
		emp.setGrade(grade);
		emp.setSalary(salary);

		return add(emp);

	}

	@Override
	public boolean updateEmployee(String name, String empId, int grade, long salary, boolean isActive) {
		Employee e1 = getEmployeeById(empId);
		if (e1 != null) {
			e1.setName(name);
			e1.setGrade(grade);
			e1.setSalary(salary);
			e1.setIsActive(isActive);
			update(e1);
			return true;
		}
		return false;

	}

	@Override
	public boolean promoteEmployee(String empId, int grade, long salary) {
		Employee e = getEmployeeById(empId);
		if (e != null) {
			e.setGrade(grade);
			e.setSalary(salary);
			update(e);
			return true;
		}
		return false;
	}

	/* Private Methods */
	

	private boolean add(Employee employee) {

		try {

			// add employee to our database list.
			sessionFactory.getCurrentSession().persist(employee);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	private boolean update(Employee employee) {

		//findingEmployee(employee);
		try {

			// update employee to our database list.
			sessionFactory.getCurrentSession().update(employee);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}


	private boolean delete(Employee employee) {

		try {

			// delete employee to our database list.
			sessionFactory.getCurrentSession().delete(employee);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
