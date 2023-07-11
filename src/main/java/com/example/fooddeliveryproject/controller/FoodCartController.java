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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddeliveryproject.auth.service.UserSessionService;
import com.example.fooddeliveryproject.authexception.AuthorizationException;
import com.example.fooddeliveryproject.entity.FoodCart;
import com.example.fooddeliveryproject.exception.CartException;
import com.example.fooddeliveryproject.exception.ItemException;
import com.example.fooddeliveryproject.service.FoodCartService;

@RestController
@RequestMapping("/carts")
public class FoodCartController {
	private FoodCartService foodCartService;

	@Autowired
	public FoodCartController(FoodCartService foodCartService) {
		super();
		this.foodCartService = foodCartService;
	}
	
	@Autowired
	UserSessionService userSessionService;
	public FoodCartController(UserSessionService userSessionService) {
		super();
		this.userSessionService = userSessionService;
	}


	@PostMapping("/register")
	public ResponseEntity<FoodCart> saveCartDetails(@RequestParam String key,@RequestBody FoodCart fc) throws CartException, AuthorizationException
	{
				Integer sessionId = userSessionService.getUserSessionId(key);
				
				if(fc!=null && sessionId != null) {
	            FoodCart f= foodCartService.saveCart(fc);
	            	return new ResponseEntity<FoodCart>(f,HttpStatus.CREATED);
	            }
	            throw new CartException();
	}
	

	@PutMapping("/add/{cartId}/{itemId}")
	public ResponseEntity<FoodCart> addItemToCart(@PathVariable("cartId") Integer cartId, @PathVariable("itemId") Integer itemId) throws CartException, ItemException{
		FoodCart updatedCart = foodCartService.addItem(cartId, itemId);
		return new ResponseEntity<FoodCart>(updatedCart, HttpStatus.ACCEPTED);
	}
	

	
	@DeleteMapping("/remove/{cartId}")
	public ResponseEntity<FoodCart> removeCart(@PathVariable("cartId") Integer cartId) throws CartException{
		FoodCart removedCart = foodCartService.clearCart(cartId);
		return new ResponseEntity<FoodCart>(removedCart, HttpStatus.OK);
	}
	
	//@ResponseBody
	@GetMapping("/view/{cartId}")
	public FoodCart getCartByCartId(@PathVariable ("cartId") Integer cartId) throws AuthorizationException, CartException{
		 
			return foodCartService.viewCart(cartId);
		 
			
	}
	
	/*
	 * @GetMapping("/view/{cartId}")
	public FoodCart getCartByCartId(@PathVariable ("cartId") Integer cartId,@RequestParam String key) throws AuthorizationException, CartException{
		
		Integer sessionId = userSessionService.getUserSessionId(key);
		if(sessionId != null)
			return foodCartService.viewCart(cartId);
		else
			 throw new CartException();
			
	}
	 */
}
