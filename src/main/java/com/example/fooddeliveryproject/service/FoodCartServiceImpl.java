package com.example.fooddeliveryproject.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddeliveryproject.entity.FoodCart;
import com.example.fooddeliveryproject.entity.Item;
import com.example.fooddeliveryproject.exception.CartException;
import com.example.fooddeliveryproject.exception.ItemException;
import com.example.fooddeliveryproject.repository.FoodCartRepository;
import com.example.fooddeliveryproject.repository.ItemRepository;

@Service
public class FoodCartServiceImpl implements FoodCartService {

	private FoodCartRepository foodCartRepository;
	@Autowired
	public FoodCartServiceImpl(FoodCartRepository foodCartRepository) {
		super();
		this.foodCartRepository = foodCartRepository;
	}
	
	private ItemRepository itemRepository;
	
	
	public FoodCartServiceImpl(FoodCartRepository foodCartRepository, ItemRepository itemRepository) {
		super();
		this.foodCartRepository = foodCartRepository;
		this.itemRepository = itemRepository;
	}

	@Override
	public FoodCart saveCart(FoodCart cart) throws CartException {
		Optional<FoodCart> opt = foodCartRepository.findById(cart.getCartId());
		if(opt.isPresent()) {
			throw new CartException("Cart already exists..");
		}else {
			 return foodCartRepository.save(cart);
		}
	}

	@Override
	public FoodCart addItem(Integer cartId, Integer itemId) throws CartException, ItemException {
		Optional<FoodCart> cOpt = foodCartRepository.findById(cartId);
		if(cOpt.isPresent()) {
			
			Optional<Item> iOpt = itemRepository.findById(itemId);
			if(iOpt.isPresent()) {
				
				FoodCart cart = cOpt.get();
				Item item = iOpt.get();
				List<Item> list = new LinkedList<>();
				list.addAll(cart.getItems());
				list.add(item);
				cart.setItems(list);
				
				return cart;
				
			}else {
				throw new ItemException("No Item found with ID: "+itemId);
			}
			
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}

	@Override
	public FoodCart clearCart(Integer cartId) throws CartException {
		Optional<FoodCart> opt = foodCartRepository.findById(cartId);
		if(opt.isPresent()) {
			FoodCart cart = opt.get();
			foodCartRepository.delete(cart);
			return cart;
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}

	@Override
	public FoodCart viewCart(Integer cartId) throws CartException {
		Optional<FoodCart> opt = foodCartRepository.findById(cartId);
		if(opt.isPresent()) {
			FoodCart cart = opt.get();
			return cart;
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}

}
