package com.yedam.app.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.department.domain.DepartmentVO;
import com.yedam.app.department.service.DepartmentService;

import lombok.extern.java.Log;

@RestController
@Log
@RequestMapping("/departments/api/*")
public class RestDepartmentController {
	
	@Autowired DepartmentService departmentService;
	
	@GetMapping("/")
	public List<DepartmentVO> getList() {
		List<DepartmentVO> list = departmentService.getList();
		return list;
	}
	
	@PostMapping("/")
	public DepartmentVO register(DepartmentVO vo) {
		
		int result = departmentService.create(vo);
		if(result == 0) {
			
		}
		return vo;
	}
	
}
