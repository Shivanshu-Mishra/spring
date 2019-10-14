package com.shiva.springboot.repositories;

import java.util.List;
import java.util.Optional;

import com.shiva.springboot.entities.Officer;

public interface OfficerDAO {
	Officer save(Officer officer);
	Optional<Officer> findbyId(Integer id);
	List<Officer> findAll();
	long count();
	void delete(Officer officer);
	boolean existById(Integer id);
	
	
	

}
