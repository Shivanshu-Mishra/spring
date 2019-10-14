package com.shiva.springboot.services;

import java.net.URLEncoder;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shiva.springboot.entities.Site;
import com.shiva.springboot.json.GeocoderResponse;

@Service
public class GeocoderService {

	private RestTemplate template;
	private Logger logger=LoggerFactory.getLogger(GeocoderService.class);
	private static final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json";
	private static final String KEY = "AIzaSyDw_d6dfxDEI7MAvqfGXEIsEMwjC1PWRno";

	@Autowired
	public GeocoderService(RestTemplateBuilder builder) {
		template = builder.build();
	}

	public Site getLatlng(String... address) {
		String encodedAddress = Stream.of(address).map(this::encodeString).collect(Collectors.joining(","));
		String url = String.format("%s?address=%s&key=%s", BASE_URL, encodedAddress, KEY);
		GeocoderResponse response = template.getForObject(url, GeocoderResponse.class);
		Site site=new Site(response.getFormattedAddress(), response.getLocation().getLat(),
				response.getLocation().getLng());
		logger.info(site.toString());
		return site;
	}

	private String encodeString(String s) {
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

}
