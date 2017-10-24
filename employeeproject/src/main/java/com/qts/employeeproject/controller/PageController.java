package com.qts.employeeproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qts.employeeprojectbackend.dao.EmployeeDAO;
import com.qts.employeeprojectbackend.dto.Employee;

@Controller
public class PageController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/listAllEmployees" })
	public ModelAndView listAllEmployees() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "List All Employees");

		// passing the list of employees
		mv.addObject("employees", employeeDAO.listAll());
		mv.addObject("userClickListAllEmployees", true);
		return mv;
	}

	@RequestMapping(value = { "/findEmployee" }, method = RequestMethod.GET)
	public ModelAndView findEmployee() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Find Employee");
		mv.addObject("userClickFindEmployee", true);
		return mv;
	}

	@RequestMapping(value = { "/getEmployees" }, method = RequestMethod.POST)
	public ModelAndView getEmployees(@RequestParam("empName") String empName) {

		// Get the employee list with name provided

		List<Employee> employeeList = new ArrayList<>();
		employeeList = employeeDAO.getEmployee(empName);
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Found Employee");

		if (employeeList.size() == 0) {
			mv.addObject("userClickFoundEmployees", false);
			return mv;
		} else {
			// passing the list of found employees
			mv.addObject("userClickFoundEmployees", true);
			mv.addObject("employees", employeeList);
			return mv;
		}
	}

	@RequestMapping(value = { "/addEmployee" }, method = RequestMethod.GET)
	public ModelAndView addEmployee() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add Employee");
		mv.addObject("userClickAddEmployee", true);
		return mv;
	}

	@RequestMapping(value = { "/results" }, method = RequestMethod.POST)
	public ModelAndView employeeAdded(@RequestParam("empName") String empName, @RequestParam("empGrade") int empGrade,
			@RequestParam("empSalary") long empSalary) {

		employeeDAO.addEmployee(empName, empGrade, empSalary);
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Employee Added");
		mv.addObject("userClickEmployeeAdded", true);

		return mv;

	}

	@RequestMapping(value = { "/updateEmployee" }, method = RequestMethod.GET)
	public ModelAndView updateEmployee() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Update Employee");
		mv.addObject("userClickUpdateEmployee", true);
		return mv;
	}

	@RequestMapping(value = { "/resultsUpdate" }, method = RequestMethod.POST)
	public ModelAndView employeeUpdated(@RequestParam("empName") String empName, @RequestParam("empId") int empId,
			@RequestParam("empGrade") int empGrade, @RequestParam("empSalary") long empSalary) {

		boolean employeeValid = employeeDAO.updateEmployee(empName, empId, empGrade, empSalary, true);
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Employee Updated");
		mv.addObject("userClickEmployeeUpdated", employeeValid);

		return mv;

	}

	@RequestMapping(value = { "/deleteEmployee" }, method = RequestMethod.GET)
	public ModelAndView deleteEmployee() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Delete Employee");
		mv.addObject("userClickDeleteEmployee", true);
		return mv;
	}

	@RequestMapping(value = { "/resultsDelete" }, method = RequestMethod.POST)
	public ModelAndView employeeUpdated(@RequestParam("empId") int empId) {

		boolean employeeValid = employeeDAO.deleteEmployee(empId);
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Employee Deletion");
		mv.addObject("userClickEmployeeDeleted", employeeValid);

		return mv;

	}

	@RequestMapping(value = { "/promoteEmployee" }, method = RequestMethod.GET)
	public ModelAndView promoteEmployee() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Promote Employee");
		mv.addObject("userClickPromoteEmployee", true);
		return mv;
	}

	@RequestMapping(value = { "/resultsPromote" }, method = RequestMethod.POST)
	public ModelAndView employeeUpdated(@RequestParam("empId") int empId, @RequestParam("empGrade") int empGrade,
			@RequestParam("empSalary") long empSalary) {

		boolean employeeValid = employeeDAO.promoteEmployee(empId, empGrade, empSalary);
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Employee Promotion");
		mv.addObject("userClickEmployeePromoted", employeeValid);

		return mv;

	}

}
