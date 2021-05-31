package com.ust.pms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
	
	@Id
	private  int productId;
	private String productName;
	private int quantityOnHand;
	private int price;
}
