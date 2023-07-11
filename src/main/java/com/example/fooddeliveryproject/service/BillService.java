package com.example.fooddeliveryproject.service;

import com.example.fooddeliveryproject.entity.Bill;
import com.example.fooddeliveryproject.exception.BillException;
import com.example.fooddeliveryproject.exception.CustomerException;
import com.example.fooddeliveryproject.exception.ItemException;

public interface BillService {
	
	public Bill addBill(Bill bill) throws BillException;
	public Bill viewBill(int billId) throws BillException;//not list
	public Bill updateBill(Bill bill) throws BillException;//in place of int Integer
	public Bill deletebyId(int billId) throws BillException;
	
	public String generateBillById(int customerId) throws ItemException,CustomerException;
	
	

}
