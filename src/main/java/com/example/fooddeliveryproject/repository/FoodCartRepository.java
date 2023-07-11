package com.example.fooddeliveryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddeliveryproject.entity.FoodCart;

public interface FoodCartRepository extends JpaRepository<FoodCart, Integer> {

}
