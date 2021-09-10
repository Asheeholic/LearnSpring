package com.yedam.app.department.domain;

import lombok.Data;

@Data
public class DepartmentVO {
	private String departmentId; // PK
	private String departmentName; // NN
	private String ManagerId; // FK
	private String locationId; // FK
}
