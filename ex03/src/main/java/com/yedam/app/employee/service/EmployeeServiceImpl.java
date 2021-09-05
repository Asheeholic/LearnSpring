package com.yedam.app.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.employee.domain.EmployeeVO;
import com.yedam.app.employee.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired EmployeeMapper employeeMapper;
	
	@Override
	public List<EmployeeVO> getList() {
		return employeeMapper.getList();
	}

	@Override
	public EmployeeVO read(EmployeeVO vo) {
		return null;
	}

	@Override
	public int create(EmployeeVO vo) {
		return 0;
	}

	@Override
	public int update(EmployeeVO vo) {
		return 0;
	}

	@Override
	public int delete(EmployeeVO vo) {
		return 0;
	}

}
