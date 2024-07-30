package com.velan.restapp.repositoryimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.velan.restapp.model.Properties;
import com.velan.restapp.repository.PropertiesRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PropertiesRepoImp implements PropertiesRepo {

	@Autowired
	EntityManager em;
	
	@Override
	public void save(Properties prop) {
		em.merge(prop);
	}

	@Override
	public List<Properties> findAllProperties() {
		String hql = "from Properties";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Properties findById(int id) {
		return em.find(Properties.class, id);
	}
	
	@Override
	public void update(Properties prop) {
		em.merge(prop);
	}
	
	@Override
	public void delete(int id) {
		Properties e=em.find(Properties.class,id);
		em.remove(e);
	}
}

