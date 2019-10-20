package com.shiva.springboot.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.shiva.springboot.entities.Officer;
import com.shiva.springboot.entities.Rank;

@DataJpaTest
@RunWith(SpringRunner.class)
@Transactional
public class OfficerRepositoryTest {

	@Autowired
	private OfficerRepository dao;
	@Autowired
	private JdbcTemplate template;
	
	@Test
	public void testSave() {
		Officer officer = new Officer(Rank.LIEUTANANT, "Nyota", "Uhuru");
		officer = dao.save(officer);
		assertNotNull(officer.getId());
	}

	@Test
	public void testFindThatDoesNotExist() {
		Optional<Officer> officer = dao.findById(999);
		assertFalse(officer.isPresent());
	}

	@Test
	public void testFindAll() {
		List<String> dbNames = dao.findAll().stream().map(Officer::getLast).collect(Collectors.toList());
		assertTrue(dbNames.contains("Kirk"));
	}

	@Test
	public void testFindById() {
		Optional<Officer> officer=dao.findById(1);
		assertTrue(officer.isPresent());
	}

	@Test
	public void testCount() {
		assertEquals(4, dao.count());
	}
	
	@Test
	public void testFindByRank() {
		assertEquals(4,dao.findByRank(Rank.CAPTAIN).size());
	}
}
