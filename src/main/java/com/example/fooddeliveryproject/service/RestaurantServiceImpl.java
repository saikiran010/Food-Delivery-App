package com.example.fooddeliveryproject.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.fooddeliveryproject.entity.Restaurant;
import com.example.fooddeliveryproject.exception.RestaurantException;
import com.example.fooddeliveryproject.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	private RestaurantRepository restaurantRepository;
	
	public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
		super();
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException {
		Optional<Restaurant> opt = restaurantRepository.findById(restaurant.getRestaurantId());
		if(opt.isPresent()) {
			throw new RestaurantException("Restaurant already exists..");
		}else {
			return restaurantRepository.save(restaurant);
		}
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException {
		Optional<Restaurant> opt = restaurantRepository.findById(restaurant.getRestaurantId());
		if(opt.isPresent()) {
			return restaurantRepository.save(restaurant);
		}else {
			throw new RestaurantException("No such Restaurant exists..");
		}
	}

	@Override
	public Restaurant removeRestaurant(Integer restaurantId) throws RestaurantException {
		Optional<Restaurant> opt = restaurantRepository.findById(restaurantId);
		if(opt.isPresent()) {
			Restaurant restaurant = opt.get();
			restaurantRepository.delete(restaurant);
			return restaurant;
		}else {
			throw new RestaurantException("No Restaurant found with ID: "+restaurantId);
		}
	}

	@Override
	public Restaurant viewRestaurant(Integer restaurantId) throws RestaurantException {
		Optional<Restaurant> opt = restaurantRepository.findById(restaurantId);
		if(opt.isPresent()) {
			Restaurant restaurant = opt.get();
			return restaurant;
		}else {
			throw new RestaurantException("No Restaurant found with ID: "+restaurantId);
		}
	}

}
