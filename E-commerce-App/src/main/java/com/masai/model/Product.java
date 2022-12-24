package com.masai.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Category{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	private String productName;
	private Double price;
	private String color;
	private String dimension;
	private String manufacturer;
	private Integer quantity;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Cart> cart;
	
	
	

}
