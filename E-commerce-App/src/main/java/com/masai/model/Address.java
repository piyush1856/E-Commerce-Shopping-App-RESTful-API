package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	private String streetNo;
	private String buildingNo;
	private String city;
	private String state;
	private String country;
	private String pincode;
	
	

}
