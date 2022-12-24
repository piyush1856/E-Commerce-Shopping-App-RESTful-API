package com.masai.model;

import java.time.LocalDateTime;

import com.masai.enums.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;






@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserSession {
	
	@Id
	private Integer userId;
	private String uuid;
	private LocalDateTime localDateTime;
	
	@Enumerated(EnumType.STRING)
	private UserType userType;
}
