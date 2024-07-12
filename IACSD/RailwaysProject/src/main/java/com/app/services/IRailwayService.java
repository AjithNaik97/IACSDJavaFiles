package com.app.services;

import java.util.List;

import com.app.entity.Category;
import com.app.entity.Railway;

public interface IRailwayService {
	
	//create
	Railway insert(Railway r);
	
	//Update
	boolean update(Railway r);
	
	//Retrieve
	List<Railway> getallRailway();
	
	//Delete
	String delete(Long Id);
	
	//find by category
	List<Railway> searchByCategory(Category cat);
}
