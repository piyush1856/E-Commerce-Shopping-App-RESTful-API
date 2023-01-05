package com.masai.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userID;
    @NotNull
    private String userName;
    @Size(min=4,max=12,message = "Password should has minimum 4 to 12 characters")
    private String password;
    @NotNull
    private String address;
    @Size(min=10, message ="Mobile Number should be of 10 digits!")
    private String mob;
    @Email
    private String email;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Orders> orders;

}
