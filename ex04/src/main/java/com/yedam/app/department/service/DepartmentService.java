package com.yedam.app.department.service;

import java.util.List;

import com.yedam.app.department.domain.DepartmentVO;

public interface DepartmentService {

	public List<DepartmentVO> getList();
	
	public int create(DepartmentVO vo);
	
}
