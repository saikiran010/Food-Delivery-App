package com.example.fooddeliveryproject.service;

import com.example.fooddeliveryproject.entity.Restaurant;
import com.example.fooddeliveryproject.exception.RestaurantException;

public interface RestaurantService {
	public Restaurant addRestaurant(Restaurant restaurant)throws RestaurantException;
	
	public Restaurant updateRestaurant(Restaurant restaurant)throws RestaurantException;
	
	public Restaurant removeRestaurant(Integer restaurantId)throws RestaurantException;
	
	public Restaurant viewRestaurant(Integer restaurantId)throws RestaurantException;
	
	
}
