package com.dxc.examples.springbootwebjpathymeleaf.catalog.airline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component("airlineService")
public class AirlineService {
	@Autowired
	private AirlineRepository airlineRepository;
	
	public List<Airline> findAll() {
		List<Airline> result = new ArrayList<>();
		for (Airline airline : airlineRepository.findAll()) {
			result.add(airline);
		}
		return result;
	}
	
	public Airline findById( Long id ) {
		Optional<Airline> optionalAirline = airlineRepository.findById( id );
		
		if( !optionalAirline.isPresent() )
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
		
		return airlineRepository.save(optionalAirline.get());
	}
	
	public Airline save( Airline airline ) {
		return airlineRepository.save(airline);
	}
	
	public Airline update( Long id, Airline airline ) {
		Optional<Airline> optionalAirline = airlineRepository.findById(id);
		
		if( !optionalAirline.isPresent() )
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
		
		return airlineRepository.save(airline);
	}
	
	public Airline update( Long id, String name, Boolean status ) {
		Optional<Airline> optionalAirline = airlineRepository.findById(id);
		
		if( !optionalAirline.isPresent() )
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
		
		Airline airline = optionalAirline.get();
		airline.setName(name);
		airline.setStatus(status);
		airline.setUpdatedate(new Date());
		
		return airlineRepository.save(airline);
	}

}
