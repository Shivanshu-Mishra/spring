package com.shiva.springboot.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.shiva.springboot.entities.Officer;
import com.shiva.springboot.entities.Rank;

@Repository
public class JdbcOfficerDao implements OfficerDAO {
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insertOfficer;

	@Autowired
	public JdbcOfficerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		insertOfficer = new SimpleJdbcInsert(jdbcTemplate).withTableName("officers").usingGeneratedKeyColumns("id");
	}

	@Override
	public Officer save(Officer officer) {
		Map<String,Object> parameters=new HashMap<>();
		parameters.put("rank",officer.getRank());
		parameters.put("first_name",officer.getFirst());
		parameters.put("last_name", officer.getLast());
		Integer id=(Integer) insertOfficer.executeAndReturnKey(parameters);
		officer.setId(id);
		return officer;
		}

	@Override
	public Optional<Officer> findbyId(Integer id) {
		if (!existById(id))
			return Optional.empty();
		return Optional.of(jdbcTemplate.queryForObject(
				"SELECT * FROM officers WHERE id=?", (rs, rowNum) -> new Officer(rs.getInt("id"),
						Rank.valueOf(rs.getString("rank")), rs.getString("first_name"), rs.getString("last_name")),
				id));
	}

	@Override
	public List<Officer> findAll() {
		return jdbcTemplate.query("SELECT * FROM officers", (rs, rowNum) -> new Officer(rs.getInt("id"),
				Rank.valueOf(rs.getString("rank")), rs.getString("first_name"), rs.getString("last_name")));
	}

	@Override
	public long count() {
		return jdbcTemplate.queryForObject("SELECT count(*) from officers", Long.class);
	}

	@Override
	public void delete(Officer officer) {
		jdbcTemplate.update("DELETE FROM officers WHERE id=?", officer.getId());
	}

	@Override
	public boolean existById(Integer id) {
		return jdbcTemplate.queryForObject("SELECT EXISTS(SELECT 1 FROM officers where id=?)", Boolean.class, id);
	}

}
