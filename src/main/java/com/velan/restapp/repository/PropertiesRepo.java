package com.velan.restapp.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.velan.restapp.model.Properties;

@Repository
public interface PropertiesRepo{

    public void save(Properties prop);
	public List<Properties> findAllProperties();
	public Properties findById(int id);
	public void update(Properties prop);
	public void delete(int id);
	
}

