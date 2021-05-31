package com.ust.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class MyNumbers {
	@Id
	@GeneratedValue
	private int attempt;
	
	private int firstNumber;
	private int secondNumber;
	 
	
	 private static int result;

	public static void setResult(int sum) {
		// TODO Auto-generated method stub
		
	}

	public int addNumbers(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
}
