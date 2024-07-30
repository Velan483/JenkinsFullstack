package com.velan.restapp.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velan.restapp.model.Properties;
import com.velan.restapp.repository.PropertiesRepo;
import com.velan.restapp.service.PropertiesService;

@Service
public class PropertiesServiceImp implements PropertiesService {

	@Autowired
	PropertiesRepo repo;

	@Override
	public void addProperties(Properties prop) {
		repo.save(prop);
	}

	@Override
	public Properties getProperties(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Properties> getAllProperties() {
		return repo.findAllProperties();
	}

	@Override
	public void updateProperties(Properties prop) {
		repo.update(prop);
	}

	@Override
	public void deleteProperties(int id) {
		repo.delete(id);
	}

}
