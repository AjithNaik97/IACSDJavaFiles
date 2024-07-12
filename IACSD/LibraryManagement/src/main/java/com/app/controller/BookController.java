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

import com.app.entities.Book;
import com.app.services.IBookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private IBookService service;

	@PostMapping
	public ResponseEntity<Book> addBook(@Valid @RequestBody Book b) {
		return new ResponseEntity<>(service.insert(b), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Book>> retriveAllBooks() {
		List<Book> blist = service.retirveAll();
		if (blist.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Book>>(blist, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<String> updateBook(@Valid @RequestBody Book b) {
		if (service.update(b)) {
			return new ResponseEntity<>("Successfully updated!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Updated failed..Invalid ID!", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{title}")
	public ResponseEntity<String> deleteBookByTitle(@PathVariable String title) {
		if (service.deleteByTitle(title)) {
			return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Delete failed", HttpStatus.BAD_REQUEST);
	}

}
