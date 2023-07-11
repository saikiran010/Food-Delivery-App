package com.example.fooddeliveryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddeliveryproject.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
