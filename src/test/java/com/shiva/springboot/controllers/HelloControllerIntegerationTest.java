package com.shiva.springboot.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerIntegerationTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testHelloWithoutName() throws Exception {
		mvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN))
		.andExpect(status().isOk())
		.andExpect(view().name("hello"))
		.andExpect(model().attribute("user",is("World")));
		
	}
	
	@Test
	public void testHelloWithName() throws Exception {
		mvc.perform(get("/hello?name=Shiva").accept(MediaType.TEXT_PLAIN))
		.andExpect(status().isOk())
		.andExpect(view().name("hello"))
		.andExpect(model().attribute("user", is("Shiva")));
	}
}
