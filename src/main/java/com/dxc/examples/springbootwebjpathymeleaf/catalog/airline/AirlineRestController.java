package com.dxc.examples.springbootwebjpathymeleaf.catalog.airline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirlineRestController {
	@Autowired
	private AirlineService service;
	
	@GetMapping("ws/airlines")
	public List<Airline> findAll() {
		return service.findAll();
	}
	
	@GetMapping("ws/airline/{id}")
	public Airline findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping("ws/airline")
	public Airline save(@RequestBody Airline airline) {
		return service.save(airline);
	}
	
	@PutMapping("ws/airline/{id}")
	public Airline update(@PathVariable Long id, @RequestBody Airline airline) {
		return service.update(id, airline);
	}
}
