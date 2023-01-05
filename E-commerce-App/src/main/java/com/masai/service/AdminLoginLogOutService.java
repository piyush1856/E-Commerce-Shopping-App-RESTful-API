package com.masai.service;

import com.masai.exception.AdminException;
import com.masai.model.AdminSignInDTO;

public interface AdminLoginLogOutService {
	
	 public String logInAdmin(AdminSignInDTO adminSignInDTO) throws AdminException;
	    
	 public String logOutAdmin(String key) throws AdminException;
	    

}
