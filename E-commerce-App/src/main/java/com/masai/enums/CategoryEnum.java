package com.masai.enums;

public enum CategoryEnum {
	
	MEN("Men"),
	WOMEN("women"),
	KIDS("kids");
	
	private String type;
	 
    private CategoryEnum(String type) {
		this.type = type;
	}
 
    public String getCategoryType() {
        return type;
    }
	

}
