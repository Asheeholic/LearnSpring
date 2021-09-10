package com.yedam.app.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.employee.service.EmployeeService;
import com.yedam.app.location.service.LocationService;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/departments/*")
public class DepartmentController {
	
	@Autowired EmployeeService employeeService;
	@Autowired LocationService locationService;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("locationList", locationService.getList());
		model.addAttribute("managerList", employeeService.findManagers());
		log.info("Department list enter");
	}
	
}
