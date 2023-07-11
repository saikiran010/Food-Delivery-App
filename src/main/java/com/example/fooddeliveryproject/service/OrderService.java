package com.example.fooddeliveryproject.service;

import java.util.List;

import com.example.fooddeliveryproject.entity.Item;
import com.example.fooddeliveryproject.entity.OrderDetails;
import com.example.fooddeliveryproject.exception.CustomerException;
import com.example.fooddeliveryproject.exception.OrderException;

public interface OrderService {
public OrderDetails addOrder(OrderDetails order)throws OrderException;
	
	public OrderDetails updateOrder(OrderDetails order)throws OrderException;
	
	public OrderDetails removeOrder(Integer orderId)throws OrderException;
	
	public OrderDetails viewOrder(Integer orderId)throws OrderException;
	
	public List<Item> viewAllOrdersByCustomer(Integer customerId)throws OrderException,CustomerException;

}
