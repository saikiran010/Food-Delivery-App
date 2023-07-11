package com.example.fooddeliveryproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddeliveryproject.entity.Item;
import com.example.fooddeliveryproject.exception.ItemException;
import com.example.fooddeliveryproject.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	private ItemRepository itemRepository;
	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}

	@Override
	public Item addItem(Item item) throws ItemException {
		Optional<Item> opt = itemRepository.findById(item.getItemId());
		if(opt.isPresent()) {
			throw new ItemException("Item already exists..");
		}else {
			return itemRepository.save(item);
		}
	}

	@Override
	public Item updateItem(Item item) throws ItemException {
		Optional<Item> opt = itemRepository.findById(item.getItemId());
		if(opt.isPresent()) {
			return itemRepository.save(item);
		}else {
			throw new ItemException("No such Item found..");
		}
	}

	@Override
	public Item viewItem(Integer itemId) throws ItemException {
		Optional<Item> opt = itemRepository.findById(itemId);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new ItemException("No Item found with ID: "+itemId);
		}
	}

	@Override
	public Item removeItem(Integer itemId) throws ItemException {
		Optional<Item> opt = itemRepository.findById(itemId);
		if(opt.isPresent()) {
			Item item = opt.get();
			itemRepository.delete(item);
			return item;
		}else {
			throw new ItemException("No Item found with ID: "+itemId);
		}
	}

	@Override
	public List<Item> viewAllItems() throws ItemException {
		List<Item> items = itemRepository.findAll();
		if(items.size() > 0) {
			return items;
		}else {
			throw new ItemException("No Item exists..");
		}
	}

}
