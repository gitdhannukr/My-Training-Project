package com.ust.pms.controller.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.UstSpingmvcProductApplication;
 
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UstSpingmvcProductApplication.class)
@WebAppConfiguration
public class AbstractTest {

	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webAppContext;

	protected void setUp() {
		mvc=MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}

	//mapToJson this function willl convert the data to JSON
	protected String mapToJson(Object obj)throws JsonProcessingException{
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
	protected <T>T mapFromJson(String json,Class<T>clazz)throws JsonProcessingException{
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

}

