package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Product")
public class Product {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long Id;
	
	@NotBlank(message="Name is mandatory!")
	private String name;
	
	@NotBlank(message="Product code is mandatory!")
	@Column(unique=true)
	private String productCode;
	
	@NotNull(message="Date of Management is mandatory!")
	private LocalDate dom;
	
	@NotNull(message="Category is mandatory!")
	@Enumerated(EnumType.STRING)
	private Category category;

	public Product () {}
	
	public Product(Long id, @NotBlank(message = "Name is mandatory!") String name,
			@NotBlank(message = "Product code is mandatory!") String productCode,
			@NotNull(message = "Date of Management is mandatory!") LocalDate dom,
			@NotNull(message = "Category is mandatory!") Category category) {
		super();
		Id = id;
		this.name = name;
		this.productCode = productCode;
		this.dom = dom;
		this.category = category;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public LocalDate getDom() {
		return dom;
	}

	public void setDom(LocalDate dom) {
		this.dom = dom;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [Id=" + Id + ", name=" + name + ", productCode=" + productCode + ", dom=" + dom + ", category="
				+ category + "]";
	}
	
	
	

}
