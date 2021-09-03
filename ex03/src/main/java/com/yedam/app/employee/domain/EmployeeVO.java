package com.yedam.app.employee.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeVO {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private String salary;
	private String commissionPct;
	private String managerId;
	private String departmentId;
}
