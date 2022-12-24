package com.masai.model;

import java.time.LocalDateTime;

import com.masai.enums.PaymentTypeEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	
	@Enumerated(EnumType.STRING)
	private PaymentTypeEnum paymentType;
	private LocalDateTime paymentTime;
	private Double paymentAmount;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Order order;
}
