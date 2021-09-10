package com.yedam.app.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.location.domain.LocationVO;
import com.yedam.app.location.mapper.LocationMapper;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired LocationMapper locationMapper;
	
	@Override
	public List<LocationVO> getList() {
		return locationMapper.getList();
	}
	
}
