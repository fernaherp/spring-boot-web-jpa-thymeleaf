package com.dxc.examples.springbootwebjpathymeleaf.catalog.airline;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AirlineController {
	@Autowired
	private AirlineService service;
	
	private static final Logger logger = LoggerFactory.getLogger(AirlineController.class);
	
	@GetMapping("/airlines")
	public String findAll(Map<String, Object> model) {
		List<Airline> airlines = service.findAll();
		
		model.put("airlines", airlines);
		
		return "airline/list";
	}
	
	@GetMapping("/airline/{id}")
	public String findById(@PathVariable Long id, Map<String, Object> model) {
		Airline airline = service.findById(id);
		model.put("airline", airline);
		
		return "/airline/" + id;
	}
	
	@PostMapping("/airline/add")
	public String save(Map<String, Object> model, @RequestParam("airline-name") String airline_name) {
		logger.info("airline_name: " + airline_name);
		Airline airline2 = new Airline(airline_name);
		service.save(airline2);
		return "redirect:/airlines";
	}
	
	@PostMapping("/airline/edit")
	public String update(Map<String, Object> model,
						 @RequestParam("airline-id") Long airline_id,
						 @RequestParam("airline-name") String airline_name,
						 @RequestParam("airline-status") Boolean airline_status) {
		logger.info("airline_id: " + airline_id);
		logger.info("airline_name: " + airline_name);
		logger.info("airline_status: " + airline_status);
		
		service.update(airline_id, airline_name, airline_status);
		return "redirect:/airlines";
	}
}
