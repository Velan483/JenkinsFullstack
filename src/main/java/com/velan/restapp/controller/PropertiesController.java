package com.velan.restapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.velan.restapp.model.Properties;
import com.velan.restapp.serviceimp.PropertiesServiceImp;

@RestController
@RequestMapping("/property")
@CrossOrigin("http://localhost:3000")
public class PropertiesController {

	@Autowired
    PropertiesServiceImp service;
	
	static final String SUCCESS="Success";
	static final String FAILURE="Failure";

	@PostMapping
	public String insertProperties(@RequestBody Properties prop) {
		String msg = "";

		try {
			service.addProperties(prop);
			msg=SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}
	
	@GetMapping("{id}")
	public Properties getPropertiesById(@PathVariable("id") int id) {
		return service.getProperties(id);
	}

	@GetMapping("/all")
	public List<Properties> getProperties() {
		return service.getAllProperties();
	}
	
	@PutMapping()
	public String updateProperties(@RequestBody Properties prop) {
		String msg = "";
		try {
			service.updateProperties(prop);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}
	
	@DeleteMapping("{id}")
	public String deletePropertiesById(@PathVariable("id")int id) {
		String msg="";
		try {
			service.deleteProperties(id);
			msg=SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			msg=FAILURE;
		}
		return msg;
	}
	
	
}
