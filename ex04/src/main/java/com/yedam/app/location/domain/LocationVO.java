package com.yedam.app.location.domain;

import lombok.Data;

@Data
public class LocationVO {
	
	private String locationId;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	private String countryId;
		
	
}
