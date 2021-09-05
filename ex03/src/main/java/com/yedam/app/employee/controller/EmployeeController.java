package com.yedam.app.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.employee.service.EmployeeService;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/employee/*")
public class EmployeeController {
	
	@Autowired EmployeeService employeeService;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", employeeService.getList());
		log.info("employee list enter");
	}
	
}
