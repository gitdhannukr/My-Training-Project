package com.ust.pms.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.pms.model.Product;
import com.ust.pms.repository.ProductRepository;

@SpringBootTest
class ProductServiceTest {
@Autowired
ProductService productService;

Product product;

@Autowired
ProductRepository productRepository;

	@BeforeEach
	void setUp() throws Exception {
		product = new Product();
		product.setProductId(100);
		product.setProductName("apple");
		product.setQuantityOnHand(20);
		product.setPrice(900);
		
	}

	
	@AfterEach
	void tearDown() throws Exception {
		productRepository.deleteById(product.getProductId());
	}

	@Test
	void testSaveProduct() {
		productRepository.save(product);
	     Product retvProduct = productRepository.findById(product.getProductId()).get();
	     assertEquals(100, retvProduct.getProductId());
	}

	
	
	@Test
	public void testUpdateProduct() {
		product.setPrice(1000);
		productRepository.save(product);
	    Product retvProduct = productRepository.findById(product.getProductId()).get();
	    assertEquals(1000, retvProduct.getPrice());
	}
}