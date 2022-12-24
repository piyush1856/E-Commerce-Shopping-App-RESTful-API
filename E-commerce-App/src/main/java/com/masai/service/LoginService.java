package com.masai.service;

import com.masai.dtoes.LogInDTO;
import com.masai.exception.CredentialException;

public interface LoginService {
	
	public String logIntoAccount(LogInDTO dto) throws CredentialException;
	
	public String logOutFromAccount(String key) throws CredentialException;

}
