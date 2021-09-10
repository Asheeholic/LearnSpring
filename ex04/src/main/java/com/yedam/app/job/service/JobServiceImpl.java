package com.yedam.app.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.job.domain.JobsVO;
import com.yedam.app.job.mapper.JobMapper;

@Service
public class JobServiceImpl implements JobService {

	@Autowired JobMapper jobMapper;
	
	@Override
	public List<JobsVO> getList() {
		return jobMapper.getList();
	}
	
}
