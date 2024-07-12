package com.app.services;

import java.util.List;

import com.app.entities.Category;
import com.app.entities.Product;

public interface IProductService {
	
	Product Insert(Product p);
	
	List<Product> getAllProducts();
	
	boolean updateProduct(Product p);
	
	boolean deleteProduct(Long id);
	
	List<Product> searchByCategory(Category category);
	
	List<Product> sortByName();
}
