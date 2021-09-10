package com.yedam.app.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.department.domain.DepartmentVO;
import com.yedam.app.department.mapper.DepartmentMapper;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired DepartmentMapper departmentMapper;
	
	@Override
	public List<DepartmentVO> getList() {
		return departmentMapper.getList();
	}

	@Override
	public int create(DepartmentVO vo) {
		return departmentMapper.create(vo);
	}

}
