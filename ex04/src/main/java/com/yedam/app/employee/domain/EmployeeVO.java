package com.yedam.app.employee.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeVO {
	private String employeeId; //pk
	private String firstName; 
	private String lastName; // nn
	private String email; // nn
	private String phoneNumber;
	private Date hireDate; // sysdate
	private String jobId; // fk (선택) // nn
	private String salary; // 최소 1
	private String commissionPct;
	private String managerId; // fk (선택)
	private String departmentId; // fk (선택)
}
