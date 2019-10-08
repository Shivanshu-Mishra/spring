package com.shiva.springboot.config;

import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
