package com.yedam.app.employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.employee.domain.EmployeeVO;
import com.yedam.app.employee.mapper.EmployeeMapper;
import com.yedam.app.employee.service.EmployeeService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class EmployeeMapperClient {
	
	@Autowired EmployeeService employeeMapper;
	
	@Test
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
	
	// 결국 모든 vo 객체를 String으로 만드는 것이 좋았다.
	// 간편하고 돌이키기도 쉽고 만약 널값을 넣을때 자바에서는 널이라는 값이 없기에.
	//@Test
	public void create() {
		EmployeeVO vo = new EmployeeVO();
		vo.setLastName("Last");
		vo.setEmail("newEmail");
		vo.setPhoneNumber("01027813969");
		vo.setJobId("IT_PROG");
		employeeMapper.create(vo);
		log.info(vo.getEmployeeId());
	}
	
	//@Test
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
