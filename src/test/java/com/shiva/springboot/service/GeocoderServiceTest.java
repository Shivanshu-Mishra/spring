package com.shiva.springboot.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.shiva.springboot.entities.Site;
import com.shiva.springboot.services.GeocoderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeocoderServiceTest {
	
	@Autowired
	private GeocoderService service;
	
	@Test
	public void testGetLongLatWithoutStreet() {
		Site site=service.getLatlng("Boston","MA");
		assertEquals(42.36,site.getLatitude(),0.01);
		assertEquals(-71.06,site.getLongitude(),0.01);
	}
	
	@Test
	public void testGetLatLongWithStreet() {
		Site site=service.getLatlng("1600 Ampitheattre Parkway","Mountain View","CA");
		assertEquals(37.42,site.getLatitude(),0.01);
		assertEquals(-122.08,site.getLongitude(),0.01);
	} 

}
