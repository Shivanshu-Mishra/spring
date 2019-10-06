package com.shiva.springboot.controllers;

import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import static org.junit.Assert.*;


public class HelloControllerTest {

	@Test
	public void testSayHello() {
		HelloController controller=new HelloController();
		Model model=new BindingAwareModelMap();		
		String result=controller.sayHello("Shiva", model);
		assertEquals("hello", result);
		
		
		
	}
}
