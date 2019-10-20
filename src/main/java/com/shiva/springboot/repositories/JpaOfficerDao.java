package com.shiva.springboot.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.shiva.springboot.entities.Officer;

@Repository
public class JpaOfficerDao implements OfficerDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Officer save(Officer officer) {
		entityManager.persist(officer);
		return officer;
	}

	@Override
	public Optional<Officer> findbyId(Integer id) {
		return Optional.ofNullable(entityManager.find(Officer.class,id));
	}

	@Override
	public List<Officer> findAll() {
		return entityManager.createQuery("SELECT o FROM Officer o", Officer.class).getResultList();
	}

	@Override
	public long count() {
		return entityManager.createQuery("SELECT count(o.id) from Officer o",Long.class).getSingleResult();
	}

	@Override
	public void delete(Officer officer) {
		entityManager.remove(officer);		
	}

	@Override
	public boolean existById(Integer id) {
		Long count=entityManager.createQuery("SELECT count(o.id) from Officer o where o.id=:id",Long.class)
				.setParameter("id", id)
				.getSingleResult();
		return count>0;
	}

}
