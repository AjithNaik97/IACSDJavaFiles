package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.entities.Category;
import com.blogs.service.CategoryService;

/*
 * @Controller at class level + @ResponseBody implicitly added 
 * on ret types of req handling methods(@RequestMapping | @GetMapping | @PostMapping)
 */

@RestController
@RequestMapping("/categories") // option but recommmended.
public class CategoryController {
	// depcy
	@Autowired
	private CategoryService categoryService;

	public CategoryController() {
		System.out.println("in ctor of " + getClass());
	}

	/*
	 * 1.Get All Categoreis Desing end point of REST API
	 * URL-http://host:port/categories Method - GET Payload(resquest data) - NONE
	 * Resp -: @ResponseBody List<Category>
	 */

	@GetMapping
	public List<Category> listAllCategories() {
		System.out.println("in list all categories");
		return categoryService.getAllCategories();
	}

	/*
	 * Design end point of REST API for adding new category(Create) URL-
	 * http://host:port/categories Method-POST Payload(request data) - category
	 * details (name and desc) : Category entity Resp - : @ResponseBody -- CAtegory
	 * (wiht generated ID)
	 */

	@PostMapping
	public Category addNewCategory(@RequestBody Category category) {
		System.out.println("in add new category" + category);
		return categoryService.addNewCategory(category);
	}

	/*
	 * Design end point of REST API for deletinh existing category(Delete) URL-
	 * http://host:port/categories/{categoryId} {URI template variable | path
	 * variable} Method-DELETE Payload(request data) - none Resp - : @ResponseBody
	 * -- plan string message
	 */

	@DeleteMapping("/{categoryId}")
	// @PathVariable - method arg level annotation, to bind incoming path var to the
	// method argument
	public ApiResponse deleteCategoryDetails(@PathVariable Long categoryId) {
		System.out.println("in delete category " + categoryId);
		return new ApiResponse(categoryService.deleteCategoryDetails(categoryId));
	}

	/*
	 * Design end point of REST API for getting existing category(GET) URL-
	 * httlp://host:port/categories/{categoryId} {URI template variable | path
	 * variable} Method-GET Payload(request data) - none Resp - : @ResponseBody --
	 * Category
	 */
	@GetMapping("/{catId}")
	public Category getCategoryDetails(@PathVariable Long catId) {
		System.out.println("in get category "+catId);
		return null;
	}

}
