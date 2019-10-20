package com.shiva.springboot.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shiva.springboot.entities.Officer;
import com.shiva.springboot.entities.Rank;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JdbcOfficerDaoTest {
	@Autowired
	@Qualifier("jdbcOfficerDao")
	private OfficerDAO dao;

	@Test
	public void save() {
		Officer officer = new Officer(Rank.LIEUTANANT, "Nyota", "Uhuru");
		officer = dao.save(officer);
		assertNotNull(officer.getId());
	}
	
	@Test
	public void findByIdThatExists() {
		Optional<Officer> officer=dao.findbyId(1);
		assertTrue(officer.isPresent());
		assertEquals("James", officer.get().getFirst());;
	}
	
	@Test
	public void findByIdThatDoesNotExist() {
		Optional<Officer> officer=dao.findbyId(999);
		assertFalse(officer.isPresent());
	}
	
	@Test
	public void testCount() {
		assertEquals(4,dao.count());
	}
	
	@Test
	public void findAll() {
		List<String> dbNames=dao.findAll().stream()
				.map(Officer::getLast)
				.collect(Collectors.toList());
		assertTrue(dbNames.contains("Janeway"));
	}
	
	@Test
	public void delete() {
		IntStream.rangeClosed(1, 4)
		.forEach(id -> {
			Optional<Officer> officer=dao.findbyId(id);
			assertTrue(officer.isPresent());
			dao.delete(officer.get());
		});
		assertEquals(0,dao.count());
	}
	
	@Test
	public void existsById() {
		IntStream.rangeClosed(1, 4)
		.forEach(id -> assertTrue(String.format("%d should exist", id),dao.existById(id)));
	}
}
