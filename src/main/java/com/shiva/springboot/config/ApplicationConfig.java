package com.shiva.springboot.config;

import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {

	
	@Bean
	public NumberFormat getEnglish() {
		return NumberFormat.getInstance(Locale.ENGLISH);
	}
	
	@Bean
	public NumberFormat getFrench() {
		return NumberFormat.getInstance(Locale.FRENCH);
	}
	
	@Bean
	@Scope("prototype")
	public NumberFormat getCannadian() {
		return NumberFormat.getInstance(Locale.CANADA);
	}
}
