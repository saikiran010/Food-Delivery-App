package com.example.fooddeliveryproject.service;

import java.util.List;

import com.example.fooddeliveryproject.entity.Item;
import com.example.fooddeliveryproject.exception.ItemException;

public interface ItemService {
	public Item addItem(Item item)throws ItemException;
	
	public Item updateItem(Item item)throws ItemException;
	
	public Item viewItem(Integer itemId)throws ItemException;
	
	public Item removeItem(Integer itemId)throws ItemException;
	
	public List<Item> viewAllItems()throws ItemException;

}
