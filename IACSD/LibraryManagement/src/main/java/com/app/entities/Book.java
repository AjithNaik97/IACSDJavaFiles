package com.app.entities;
/*
id (Long): Unique identifier for the book (auto-generated).
title (String): Title of the book.
author (String): Author of the book.
isbn (String): ISBN number of the book.
genre (enum): Genre of the book (FICTION, NON_FICTION, SCIENCE, HISTORY, BIOGRAPHY).
price (BigDecimal): Price of the book.
available (boolean): Availability status of the book.
*/

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private Long id;
	
	@NotBlank(message="Title is mandatory")
	private String title;
	@NotBlank(message="Author is mandatory")
	private String author;
	@NotBlank(message="ISBN is mandatory")
	private String isbn;
	
	@Enumerated( EnumType.STRING)
	@NotNull(message="Genre is mandatory")
	private Genre genre;
	
	@NotNull(message="Price is mandatory")
	private BigDecimal price;
	
	private boolean available;
	
	public Book() {}

	public Book(Long id, @NotBlank(message = "Title is mandatory") String title,
			@NotBlank(message = "Author is mandatory") String author,
			@NotBlank(message = "ISBN is mandatory") String isbn, Genre genre,
			@NotNull(message = "Price is mandatory") BigDecimal price, boolean available) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.genre = genre;
		this.price = price;
		this.available = available;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
				+ ", available=" + available + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
}
