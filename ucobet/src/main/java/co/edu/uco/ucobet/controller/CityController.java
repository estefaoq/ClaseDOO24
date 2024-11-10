package co.edu.uco.ucobet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.controller.response.concrete.GenericResponse;
import co.edu.uco.ucobet.dto.CityDTO;

@RestController
@RequestMapping("api/v1/cities")
public final class CityController {
	
	@GetMapping("/dummy")
	public CityDTO getDummy() {
		return CityDTO.create();
	}
	
	
	@PostMapping
	public ResponseEntity<GenericResponse> create(@RequestBody CityDTO city) {
		var messages = new ArrayList<String>();
		messages.add("");
		return GenerateReponse.generateSuccessReponse(messages);
	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GenericResponse> update( @PathVariable String id, @RequestBody CityDTO city) {
		city.setId(id);
		return city;
	
	}
	
	@DeleteMapping("/{id}")
	public String delete( @PathVariable String id) {
		
		return id;
	
	}
	
	@GetMapping
	public ResponseEntity<GenericResponse> retrieveAll() {
		var list = new ArrayList<CityDTO>();
		list.add(getDummy());
		list.add(getDummy());
		list.add(getDummy());
		list.add(getDummy());
		
		return list;
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GenericResponse> retrieveById(@PathVariable String id) {
		
		return getDummy().setId(id);
	
	}




}
