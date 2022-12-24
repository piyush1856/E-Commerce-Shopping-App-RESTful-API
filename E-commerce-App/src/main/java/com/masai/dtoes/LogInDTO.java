package com.masai.dtoes;

import com.masai.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogInDTO {
	
	private String emailId;
	private String password;
	private UserType userType;

}
