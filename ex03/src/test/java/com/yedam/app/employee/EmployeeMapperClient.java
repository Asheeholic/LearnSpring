package com.yedam.app.employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.employee.domain.EmployeeVO;
import com.yedam.app.employee.mapper.EmployeeMapper;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class EmployeeMapperClient {
	
	@Autowired EmployeeMapper employeeMapper;
	
	//@Test
	public void getList() {
		log.info(employeeMapper.getList().toString());
	}
	
	//@Test
	public void read() {
		EmployeeVO vo = new EmployeeVO();
		vo.setEmployeeId("100");
		vo = employeeMapper.read(vo);
		log.info(vo.toString());
	}
	
	@Test
	public void create() {
		EmployeeVO vo = new EmployeeVO();
		vo.setLastName("Last");
		vo.setEmail("newEmail");
		vo.setPhoneNumber("01027813969");
		vo.setJobId("IT_PROG");
		employeeMapper.create(vo);
		log.info(vo.getEmployeeId());
	}
	
	
	public void update() {
		EmployeeVO vo = new EmployeeVO();
		vo = employeeMapper.read(vo);
		log.info(vo.toString());
	}
	public void delete() {
		EmployeeVO vo = new EmployeeVO();
		vo = employeeMapper.read(vo);
		log.info(vo.toString());
	}
	
}
