package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Category;
import com.app.entity.Railway;
import com.app.services.IRailwayService;

@RestController
@RequestMapping("/railway")
public class RailwayController {
	
	@Autowired
	private IRailwayService service;
	
	@PostMapping
	public ResponseEntity<Railway> Insert(@Valid @RequestBody Railway r) {
		Railway rail= service.insert(r);
		return new ResponseEntity<Railway>(rail, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Railway>> getllAllRailway()
	{
		List<Railway> rlist= service.getallRailway();
		if(rlist.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(rlist, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> Update(@Valid @RequestBody Railway r)
	{
		if(service.update(r)) {
			return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
		}
		return new ResponseEntity<>("Failed to update..!",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public String Delete(@PathVariable Long id) {
		return service.delete(id);
	}
	
	@GetMapping("/{category}")
	public ResponseEntity<List<Railway>> getByCategory(@PathVariable Category category)
	{
		List<Railway> crlist= service.searchByCategory(category);
		if(crlist.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(crlist, HttpStatus.OK);
	}

}
