package com.shiva.springboot.repositories;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shiva.springboot.entities.Officer;

@Repository
public class JdbcOfficerDao implements OfficerDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcOfficerDao(DataSource dataSource) {
		jdbcTemplate=new JdbcTemplate(dataSource);
	}

	@Override
	public Officer save(Officer officer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Officer> findbyId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Officer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		return jdbcTemplate.queryForObject("SELECT count(*) from officers", Long.class);
	}

	@Override
	public void delete(Officer officer) {
		jdbcTemplate.update("DELETE FROM officers WHERE id=?",officer.getId());
	}

	@Override
	public boolean existById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
