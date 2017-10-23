package com.qts.employeeproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value = {"/findEmployee"})
	public ModelAndView findEmployee() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Find Employee");
		mv.addObject("userClickFindEmployee", true);
		return mv;
	}
	
	@RequestMapping(value = {"/addEmployee"})
	public ModelAndView addEmployee() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add Employee");
		mv.addObject("userClickAddEmployee", true);
		return mv;
	}
	
	@RequestMapping(value = {"/updateEmployee"})
	public ModelAndView updateEmployee() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Update Employee");
		mv.addObject("userClickUpdateEmployee", true);
		return mv;
	}
	
	@RequestMapping(value = {"/deleteEmployee"})
	public ModelAndView deleteEmployee() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Delete Employee");
		mv.addObject("userClickDeleteEmployee", true);
		return mv;
	}
	
}
