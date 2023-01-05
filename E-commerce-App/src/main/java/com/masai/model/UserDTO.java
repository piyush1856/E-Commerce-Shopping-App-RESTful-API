package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserDTO {
	
    @Id
    private Integer userID;
    @Size(min = 5,message = "User should be customer")
    private String userType = "User";
    @Size(min=4,max=12,message = "Password should has minimum 4 to 12 characters")
    private String password;

}
