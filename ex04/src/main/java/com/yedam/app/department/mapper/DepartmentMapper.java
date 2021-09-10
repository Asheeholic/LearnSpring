package com.yedam.app.department.mapper;

import java.util.List;

import com.yedam.app.department.domain.DepartmentVO;

public interface DepartmentMapper {

	public List<DepartmentVO> getList();
	
	public int create(DepartmentVO vo);
	
}
