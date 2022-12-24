package com.masai.model;

import java.time.LocalDateTime;

import com.masai.enums.OrderStatusEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatusEnum orderStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
//	@Embedded
//	private Address address;
	
	
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "order")
	private Payment payment;
	
	
	
	
	
	
	
	
	
	
	
	
}
