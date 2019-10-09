package com.shiva.springboot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.text.NumberFormat;

import org.apache.commons.logging.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	private Logger logger = LoggerFactory.getLogger(ApplicationTests.class);
	@Autowired
	private ApplicationContext context;
	
	@Autowired @Qualifier("getEnglish")
	private NumberFormat englishNf;
	
	@Autowired @Qualifier("getFrench")
	private NumberFormat frenchNf;

	@Test
	public void testEnglishNumberFormat() {
		double amount = 12345678.9012345;
		String formattedCurrency=englishNf.format(amount);
		assertEquals(formattedCurrency,"12,345,678.901");
	}
	
	@Test
	public void testFrenchNumberFormat() {
		double amount = 12345678.9012345;
		String formattedCurrency=frenchNf.format(amount);		
		assertEquals(formattedCurrency,"12 345 678,901");
	}

	@Test
	public void contextLoads() {
		assertNotNull(context);
		double amount = 12345678.9012345;
		NumberFormat frenchNfBean=context.getBean("getFrench",NumberFormat.class);
		assertNotNull(frenchNfBean);
		String formattedCurrency=frenchNfBean.format(amount);
		assertEquals(formattedCurrency,"12 345 678,901");		
	}
	
	@Test
	public void testPrototypeScopedBean() {
		NumberFormat cannadian1=context.getBean("getCannadian",NumberFormat.class);
		NumberFormat cannadian2=context.getBean("getCannadian",NumberFormat.class);
		assertNotSame(cannadian1, cannadian2);
	}

}
