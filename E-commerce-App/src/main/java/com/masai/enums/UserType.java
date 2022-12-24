package com.masai.enums;

public enum UserType {
	
	ADMIN("Admin"),
	CUSTOMER("Customer");
	
	private String type;
	 
    private UserType(String type) {
		this.type = type;
	}
 
    public String getUserType() {
        return type;
    }

}
