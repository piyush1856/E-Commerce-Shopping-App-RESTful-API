package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dtoes.LogInDTO;
import com.masai.enums.UserType;
import com.masai.exception.CredentialException;
import com.masai.model.User;
import com.masai.model.UserSession;
import com.masai.repository.AdminRepo;
import com.masai.repository.CustomerRepo;
import com.masai.repository.SessionRepo;

import net.bytebuddy.utility.RandomString;




@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private CustomerRepo cRepo;
	
	@Autowired
	private AdminRepo aRepo;
	
	@Autowired
	private SessionRepo sRepo;
	
	
	
	

	@Override
	public String logIntoAccount(LogInDTO dto) throws CredentialException {
		
		User existingUser = null;
		
		
		if(dto.getUserType().equals(UserType.ADMIN)) {
			existingUser = aRepo.findByAdminEmail(dto.getEmailId());
			
		}else if(dto.getUserType().equals(UserType.CUSTOMER)){
			
			existingUser = cRepo.findByEmail(dto.getEmailId());
		}
		
		
		if(existingUser == null) {
			throw new CredentialException("Invalid Email ID");
		}
		
		
		Optional<UserSession> userSession =  sRepo.findById(existingUser.getUserId());
		
		
		if(userSession.isPresent()) {
			 throw new CredentialException("Customer is already logged in");
		}
		
		
		if(! existingUser.getPassword().equals(dto.getPassword())) {
			throw new CredentialException("Invalid password");			 
		}
		 
	
	    String key = RandomString.make(6);
	    
	    UserSession session = new UserSession(existingUser.getUserId(), key, LocalDateTime.now(), dto.getUserType());
		
	    sRepo.save(session);

		return "Logged In Successful.. " + session.toString();
		
	}

	@Override
	public String logOutFromAccount(String key) throws CredentialException {
		
		UserSession session = sRepo.findByUuid(key);
		
		if(session == null) {
			throw new CredentialException("User is not logged in with this account");
		}
		
		sRepo.delete(session);
		
		return "Logged Out Successfully... " + session.getLocalDateTime();
		
		
	}

}
