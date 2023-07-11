package com.example.fooddeliveryproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddeliveryproject.auth.service.UserSessionService;
import com.example.fooddeliveryproject.authexception.AuthorizationException;
import com.example.fooddeliveryproject.entity.Customer;
import com.example.fooddeliveryproject.entity.Restaurant;
import com.example.fooddeliveryproject.exception.CustomerException;
import com.example.fooddeliveryproject.exception.RestaurantException;
import com.example.fooddeliveryproject.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	
	@Autowired
	RestaurantService restService;
	
	
	public RestaurantController() {
		super();
	}


	public RestaurantController(RestaurantService restService) {
		super();
		this.restService = restService;
	}


	@Autowired
	UserSessionService userSessionService;
	
	
	
	public RestaurantController(UserSessionService userSessionService) {
		super();
		this.userSessionService = userSessionService;
	}


	@PostMapping("/add")
	public ResponseEntity<Restaurant> saveResturant(@RequestBody Restaurant restaurant) throws RestaurantException {
		//public ResponseEntity<Restaurant> saveResturant(@Valid @RequestBody Restaurant restaurant) throws RestaurantException
		Restaurant newRestaurant = restService.addRestaurant(restaurant);
		
		return new ResponseEntity<Restaurant>(newRestaurant ,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Restaurant> updateResturant(@RequestBody Restaurant restaurant) throws RestaurantException{
		//public ResponseEntity<Restaurant> updateResturant(@Valid @RequestBody Restaurant restaurant) throws RestaurantException
		Restaurant updatedResturant=restService.updateRestaurant(restaurant);
		
		return new ResponseEntity<Restaurant>(updatedResturant,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/remove/{restaurantId}")
	public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable("restaurantId") Integer restaurantId) throws RestaurantException{
		Restaurant removedRestaurant = restService.removeRestaurant(restaurantId);
		return new ResponseEntity<Restaurant>(removedRestaurant, HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{restaurantId}")
	public ResponseEntity<Restaurant> getByResturantId(@PathVariable ("restaurantId") Integer restaurantId) throws RestaurantException, AuthorizationException{
		
		 
    	 
    			Restaurant restaurant =restService.viewRestaurant(restaurantId);	
    			return new ResponseEntity<Restaurant>(restaurant ,HttpStatus.ACCEPTED);
    		 
	}
	/*
	 * @GetMapping("/view/{restaurantId}")
	public ResponseEntity<Restaurant> getByResturantId(@PathVariable ("restaurantId") Integer restaurantId ,@RequestParam String key) throws RestaurantException, AuthorizationException{
		
		Integer sessionId = userSessionService.getUserSessionId(key);
    	
    	if(sessionId != null)
    		{	Restaurant restaurant =restService.viewRestaurant(restaurantId);	
    			return new ResponseEntity<Restaurant>(restaurant ,HttpStatus.ACCEPTED);
    		}
    	else
    		throw new RestaurantException();
	}
	 */
	/*
	 	public ResponseEntity<Customer> viewCustomer(@PathVariable("customerId") Integer customerId) throws CustomerException{
		 Customer customer = customerService.viewCustomer(customerId);
		 return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	
	 */
	
	
}
