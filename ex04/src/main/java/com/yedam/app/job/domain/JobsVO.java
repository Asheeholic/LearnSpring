package com.yedam.app.job.domain;

import lombok.Data;

@Data
public class JobsVO {
	private String jobId;
	private String jobTitle;
	private String minSalary;
	private String maxSalary;
}
