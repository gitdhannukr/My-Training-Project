package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 

class MyNumbers {
	
	MyNumbers myNumbers;

		@BeforeEach
		void setUp() throws Exception {
			myNumbers = new MyNumbers();
		}

		@AfterEach
		void tearDown() throws Exception {
		}

		@Test

			public void testAdd() {
				int result = myNumbers.addNumbers(5,3);
				assertEquals(result,8);
		}
		private int addNumbers(int i, int j) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Test

		public void testAdd1() {
			int result = myNumbers.multiplyNumbers(5,3);
			assertEquals(result,15);
	}
	/*
	 * @Test
	 * 
	 * public void testAdd3() { int result = mathOperations.subNumbers(5,3);
	 * assertEquals(result,2); }
	 */

		private int multiplyNumbers(int i, int j) {
			// TODO Auto-generated method stub
			return 0;
		} 

	}