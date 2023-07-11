package com.example.fooddeliveryproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddeliveryproject.entity.Category;
import com.example.fooddeliveryproject.exception.CategoryException;
import com.example.fooddeliveryproject.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category addCategory(Category category) throws CategoryException {
		// TODO Auto-generated method stub
		Optional<Category> opt = categoryRepository.findById(category.getCategoryId());
		if(opt.isPresent()) {
			throw new CategoryException("Category already exists..");
		}else {
			return categoryRepository.save(category);
		}
	}

	@Override
	public Category updateCategory(Category category) throws CategoryException {
		Optional<Category> opt = categoryRepository.findById(category.getCategoryId());
		if(opt.isPresent()) {
			return categoryRepository.save(category);
		}else {
			throw new CategoryException("No such Category found..");
		}
	}

	@Override
	public Category viewCategory(Integer categoryId) throws CategoryException {
		// TODO Auto-generated method stub
		Optional<Category> opt = categoryRepository.findById(categoryId);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new CategoryException("No Category found with ID: "+categoryId);
		}
	}

	@Override
	public Category removeCategory(Integer categoryId) throws CategoryException {
		// TODO Auto-generated method stub
		Optional<Category> opt = categoryRepository.findById(categoryId);
		if(opt.isPresent()) {
			Category cat = opt.get();
			categoryRepository.delete(cat);
			return cat;
		}else {
			throw new CategoryException("No Category found with ID: "+categoryId);
		}
	}

	@Override
	public List<Category> viewAllCategory() throws CategoryException {
		// TODO Auto-generated method stub
		List<Category> categories = categoryRepository.findAll();
		if(categories.size() > 0) {
			return categories;
		}else {
			throw new CategoryException("No Categories exists..");
		}
	}
}
