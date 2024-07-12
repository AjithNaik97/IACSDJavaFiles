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

import com.app.entities.Category;
import com.app.entities.Product;
import com.app.services.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService service;

	@PostMapping
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product p) {
		Product cp = service.Insert(p);
		return new ResponseEntity<>(cp, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts()
	{
		List<Product> plist=service.getAllProducts();
		if(plist.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(plist, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> updateProduct(@Valid @RequestBody Product p)
	{
		if(service.updateProduct(p)) {
			return new ResponseEntity<>("Successfully updated",HttpStatus.OK);
		}
		return new ResponseEntity<>("Updated failed...Invalid Id!",HttpStatus.NOT_MODIFIED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		if(service.deleteProduct(id)) {
			return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
		}
		return new ResponseEntity<>("Delete falied!",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{category}")
	public ResponseEntity<List<Product>> getAllByCategory(@PathVariable Category category)
	{
		List<Product> cplist = service.searchByCategory(category);
		if(cplist.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cplist,HttpStatus.OK);
	}
	
	@GetMapping("/sort")
	public ResponseEntity<List<Product>> sortByName()
	{
		List<Product> splist=service.sortByName();
		if(splist.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(splist, HttpStatus.OK);
	}
}
