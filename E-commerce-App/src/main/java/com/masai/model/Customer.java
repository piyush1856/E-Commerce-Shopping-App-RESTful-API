package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User{
	

	private String customerName;
	private String mobileNumber;
	private String email;
	
	
	@Embedded
	@ElementCollection
	private List<Address> addresses;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
	private Cart cartInCustomer;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Orders> orders = new ArrayList<>();
	
}














