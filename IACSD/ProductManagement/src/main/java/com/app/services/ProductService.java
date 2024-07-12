package com.app.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Category;
import com.app.entities.Product;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductService implements IProductService {
	
	@Autowired
	private ProductRepository repo;

	@Override
	public Product Insert(Product p) {
		return repo.save(p);
	}

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public boolean updateProduct(Product p) {
		if(repo.existsById(p.getId())) {
			repo.save(p);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteProduct(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Product> searchByCategory(Category category) {
		return repo.findByCategory(category);
	}

	@Override
	public List<Product> sortByName() {
		return repo.sortByName();
	}
	
	

}
