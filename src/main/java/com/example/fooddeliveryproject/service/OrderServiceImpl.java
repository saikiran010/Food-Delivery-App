package com.example.fooddeliveryproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddeliveryproject.entity.Customer;
import com.example.fooddeliveryproject.entity.Item;
import com.example.fooddeliveryproject.entity.OrderDetails;
import com.example.fooddeliveryproject.exception.CustomerException;
import com.example.fooddeliveryproject.exception.OrderException;
import com.example.fooddeliveryproject.repository.CustomerRepository;
import com.example.fooddeliveryproject.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public OrderServiceImpl() {
		super();
	}

	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public OrderServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public OrderDetails addOrder(OrderDetails order) throws OrderException {
		Optional<OrderDetails> opt = orderRepository.findById(order.getOrderId());
		if(opt.isPresent()) {
			throw new OrderException("Order already exists..");
		}else {
			return orderRepository.save(order);
		}
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) throws OrderException {
		Optional<OrderDetails> opt = orderRepository.findById(order.getOrderId());
		if(opt.isPresent()) {
			return orderRepository.save(order);
		}else {
			throw new OrderException("Order such Order exists..");
		}
	}

	@Override
	public OrderDetails removeOrder(Integer orderId) throws OrderException {
		Optional<OrderDetails> opt = orderRepository.findById(orderId);
		if(opt.isPresent()) {
			OrderDetails order = opt.get();
			orderRepository.delete(order);
			return order;
		}else {
			throw new OrderException("No Order found with ID: "+orderId);
		}
	}

	@Override
	public OrderDetails viewOrder(Integer orderId) throws OrderException {
		Optional<OrderDetails> opt = orderRepository.findById(orderId);
		if(opt.isPresent()) {
			OrderDetails order = opt.get();
			return order;
		}else {
			throw new OrderException("No Order found with ID: "+orderId);
		}
	}

	@Override
	public List<Item> viewAllOrdersByCustomer(Integer customerId) throws OrderException, CustomerException {
		Optional<Customer> cOpt =customerRepository.findById(customerId);
		if(cOpt.isPresent()) {
			Customer customer = cOpt.get();
			 List<Item> itemList = customer.getFoodcart().getItems();
			 if(itemList.size() > 0) {
				 return itemList;
			 }else {
				 throw new OrderException("No Orders found..");
			 }
		}else {
			throw new CustomerException("No Customer found with ID: "+customerId);
		}
	}

}
