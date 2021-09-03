package com.yedam.app.employee.mapper;

import java.util.List;


import com.yedam.app.employee.domain.EmployeeVO;


public interface EmployeeMapper {
	public List<EmployeeVO> getList();
	
	public EmployeeVO read(EmployeeVO vo);
	
	public int create(EmployeeVO vo);
	
	public int update(EmployeeVO vo);
	
	public int delete(EmployeeVO vo);
}
