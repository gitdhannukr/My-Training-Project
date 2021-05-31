package com.ust.pms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Data

public class Product {

	@Id
	//@Min(value = 1 ,message="product id is required")
	private int productId;
	//@NotBlank(message="product name is required")
	private String productName;
	//@NotNull(message="Quantity On Hand is required")
	private int quantityOnHand;
	//@NotNull(message="price is required")
	private int price;

}
