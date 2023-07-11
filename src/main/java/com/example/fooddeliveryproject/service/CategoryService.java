package com.example.fooddeliveryproject.service;

import java.util.List;

import com.example.fooddeliveryproject.entity.Category;
import com.example.fooddeliveryproject.exception.CategoryException;

public interface CategoryService {
	
	public Category addCategory(Category category)throws CategoryException;
	
	public Category updateCategory(Category category)throws CategoryException;
	
	public Category viewCategory(Integer categoryId)throws CategoryException;
	
	public Category removeCategory(Integer categoryId)throws CategoryException;
	
	public List<Category> viewAllCategory()throws CategoryException;

}
