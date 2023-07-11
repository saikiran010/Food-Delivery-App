package com.example.fooddeliveryproject.service;

import com.example.fooddeliveryproject.entity.Customer;
import com.example.fooddeliveryproject.exception.CustomerException;

public interface CustomerService {
	public Customer addCustomer(Customer customer)throws CustomerException;
	
	public Customer updateCustomer(Customer customer)throws CustomerException;
	
	public Customer removeCustomerById(Integer customerId)throws CustomerException;
	
	public Customer viewCustomer(Integer customerId)throws CustomerException;

}
