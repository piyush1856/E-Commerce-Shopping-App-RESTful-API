package com.masai.model;

import com.masai.enums.CategoryEnum;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	
	@Enumerated(EnumType.STRING)
	private CategoryEnum categoryType;

}
