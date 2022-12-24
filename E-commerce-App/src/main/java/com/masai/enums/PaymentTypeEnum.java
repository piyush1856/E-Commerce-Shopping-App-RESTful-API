package com.masai.enums;

public enum PaymentTypeEnum {
	
	COD("COD"),
	UPI("UPI"),
	E_WALLET("E-Wallet"),
	NET_BANKING("Net Banking");
	
	private String type;
	 
    private PaymentTypeEnum(String type) {
		this.type = type;
	}
 
    public String getPaymentType() {
        return type;
    }

}
