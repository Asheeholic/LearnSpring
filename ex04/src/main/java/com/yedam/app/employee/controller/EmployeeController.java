package com.yedam.app.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.department.service.DepartmentService;
import com.yedam.app.employee.domain.EmployeeVO;
import com.yedam.app.employee.service.EmployeeService;
import com.yedam.app.job.domain.JobsVO;
import com.yedam.app.job.service.JobService;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/employees/*")
public class EmployeeController {
	
	@Autowired EmployeeService employeeService;
	@Autowired DepartmentService departmentService;
	@Autowired JobService jobService;
	
	// 모델에 기본적으로 담아줌 (잘 쓰면 코드 재사용 줄일것 같음)
	@ModelAttribute("opt")
	public Map<String, Object> opt() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jobList", jobService.getList());
		map.put("deptList", departmentService.getList());
		map.put("managerList", employeeService.findManagers());
		return map;
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", employeeService.getList());
		log.info("employee list enter");
	}
	
	@GetMapping("/get/{employeeId}")
	public String get(@PathVariable("employeeId") String employeeId,
			EmployeeVO vo, Model model) {
		vo.setEmployeeId(employeeId);
		model.addAttribute("employee", employeeService.read(vo));
		return "/employees/get";
	}
	
	@GetMapping("/register")
	public String register() {
		return "/employees/get";
	}
	
	@PostMapping("/register")
	public String registerPost(EmployeeVO vo) {
		employeeService.create(vo);
		
		return "redirect:/employees/list";
	}
	
	@PostMapping("/modify") 
	public String modifyPost(EmployeeVO vo) {
		employeeService.update(vo);
		
		return "redirect:/employees/list";
	}
	
}
