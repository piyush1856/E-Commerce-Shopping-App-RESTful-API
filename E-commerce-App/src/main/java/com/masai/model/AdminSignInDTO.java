package com.masai.model;

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
public class AdminSignInDTO {
	
    private String mobile;
    @Size(min=4,max=12,message = "Password should has minimum 4 to 12 characters")
    private String password;

}
