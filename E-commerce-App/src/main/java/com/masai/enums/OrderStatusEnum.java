package com.masai.enums;

public enum OrderStatusEnum {
	
	INPROGRESS("Inprogess"),
	CONFIRM("Confirm"),
	SHIPPED("Shipped"),
	CANCELLED("Cancelled"),
	COMPLETED("Completed");
	
	
	private String type;
	 
    private OrderStatusEnum(String type) {
		this.type = type;
	}
 
    public String getOrderStatusType() {
        return type;
    }

}
