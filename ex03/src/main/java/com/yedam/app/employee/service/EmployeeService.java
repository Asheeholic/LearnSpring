package com.yedam.app.employee.service;

import java.util.List;

import com.yedam.app.employee.domain.EmployeeVO;

public interface EmployeeService {

	public List<EmployeeVO> getList();
	
	public EmployeeVO read(EmployeeVO vo);
	
	public int create(EmployeeVO vo);
	
	public int update(EmployeeVO vo);
	
	public int delete(EmployeeVO vo);
	
}
