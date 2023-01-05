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
public class AdminDTO {
	

    @Id
    private Integer adminID;
    @Size(min = 5,message = "User should be admin")
    private String userType = "Admin";
    @Size(min=4,max=12,message = "Password should has minimum 4 to 12 characters")
    private String password;

}
