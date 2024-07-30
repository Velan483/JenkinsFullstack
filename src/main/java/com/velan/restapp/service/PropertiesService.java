package com.velan.restapp.service;

import java.util.List;
import com.velan.restapp.model.Properties;

public interface PropertiesService {
	public void addProperties(Properties prop);
	public List<Properties> getAllProperties();
	public Properties getProperties(int id);
	public void updateProperties(Properties prop);
	public void deleteProperties(int id);
}

