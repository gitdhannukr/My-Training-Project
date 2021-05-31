package com.ust.pms.controller.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ust.pms.model.Product;

public class ProductControllerTest extends AbstractTest{
	
	@Before
	@Override
	public void setUp() {
		super.setUp();
	}
	
	String uri="/product";
	@Test
	public void testGetProducts()throws Exception{
		
		
		System.out.println("JJJ");
		
		MvcResult mvcResult=(MvcResult) mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status=mvcResult.getResponse().getStatus();
		assertEquals(200,status);
		
		String content=mvcResult.getResponse().getContentAsString();
		Product productList[]=super.mapFromJson(content, Product[].class);
		
		assertTrue(productList.length>0);
	}
	/*
	 * @Test void testDeleteProduct() { fail("not yet implemented"); }
	 */
	
	@Test
	public void testSaveProducts()throws Exception{
		int productId=2;
		Product product=new Product(productId,"Lakme",900,898);
		String inputJson=super.mapToJson(product);
		 
		
		MvcResult mvcResult=(MvcResult) mvc.perform(MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status=mvcResult.getResponse().getStatus();
		assertEquals(200,status);
		
		String content=mvcResult.getResponse().getContentAsString();
		assertEquals(content,"Product saved sucessfully");
	  
	    // MockMvcRequestBuilders.delete(uri+"/"+productId);
	}
	
	@Test
	public void testUpdateProducts()throws Exception{
		 
		Product product=new Product(1,"Lakme",900,898);
		String inputJson=super.mapToJson(product);
		 
		
		MvcResult mvcResult=(MvcResult) mvc.perform(MockMvcRequestBuilders.put(uri).accept(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status=mvcResult.getResponse().getStatus();
		assertEquals(201,status);
		
		String content=mvcResult.getResponse().getContentAsString();
		assertEquals(content,"Product Update sucessfully");
	  
	     MockMvcRequestBuilders.delete(uri+"/");
	}

}
