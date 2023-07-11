package com.example.fooddeliveryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddeliveryproject.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
