package com.example.fooddeliveryproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddeliveryproject.entity.Category;
import com.example.fooddeliveryproject.exception.CategoryException;
import com.example.fooddeliveryproject.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	private CategoryService categoryService;
	@Autowired
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) throws CategoryException{
		Category newCategory = categoryService.addCategory(category);
		return new ResponseEntity<Category>(newCategory, HttpStatus.CREATED); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws CategoryException{
		Category updatedCategory = categoryService.updateCategory(category);
		return new ResponseEntity<Category>(updatedCategory, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/view/{categoryId}")
	public ResponseEntity<Category> getCategory(@PathVariable("categoryId") Integer categoryId) throws CategoryException{
		Category category = categoryService.viewCategory(categoryId);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

}
