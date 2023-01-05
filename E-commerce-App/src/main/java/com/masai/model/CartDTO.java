package com.masai.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
	
	 private Integer cartId;
	 private Integer product_quantity;
	 private Integer total_price;
	 private List<Product> products;

}
