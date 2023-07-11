package com.example.fooddeliveryproject.service;

import com.example.fooddeliveryproject.entity.FoodCart;
import com.example.fooddeliveryproject.exception.CartException;
import com.example.fooddeliveryproject.exception.ItemException;

public interface FoodCartService {
	public FoodCart saveCart(FoodCart cart)throws CartException;
	
	public FoodCart addItem(Integer cartId, Integer itemId)throws CartException,ItemException;
	
	public FoodCart clearCart(Integer cartId)throws CartException;
	
	public FoodCart viewCart(Integer cartId)throws CartException;

}
