package com.example.fooddeliveryproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddeliveryproject.entity.Bill;
import com.example.fooddeliveryproject.entity.Customer;
import com.example.fooddeliveryproject.entity.Item;
import com.example.fooddeliveryproject.exception.BillException;
import com.example.fooddeliveryproject.exception.CustomerException;
import com.example.fooddeliveryproject.exception.ItemException;
import com.example.fooddeliveryproject.repository.BillRepository;
import com.example.fooddeliveryproject.repository.CustomerRepository;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;
	
	public BillServiceImpl(BillRepository billRepository) {
		super();
		this.billRepository = billRepository;
	}
	@Autowired
	private CustomerRepository customerRepository;
	
	


	public BillServiceImpl() {
		super();
	}

	public BillServiceImpl(BillRepository billRepository, CustomerRepository customerRepository) {
		super();
		this.billRepository = billRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public Bill addBill(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		Optional<Bill> opt = billRepository.findById(bill.getBillId());
		if(opt.isPresent()) {
			throw new BillException("Bill already exist...");
			
		}
		else {
			return billRepository.save(bill);
		}
	}

	@Override
	public Bill viewBill(int billId) throws BillException {
		// TODO Auto-generated method stub
		Optional<Bill> opt = billRepository.findById(billId);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new BillException("Bill not found with Id:"+billId);
		}
		 
	}

	@Override
	public Bill updateBill(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		Optional<Bill> opt = billRepository.findById(bill.getBillId());
		if(opt.isPresent()) {
			return billRepository.save(bill);
		}
		else {
			throw new BillException("Bill doesn't exist...");
			
		}
		
	}

	@Override
	public Bill deletebyId(int billId) throws BillException {
		// TODO Auto-generated method stub
		Optional<Bill> opt = billRepository.findById( billId);
		if(opt.isPresent()) {
			 Bill bill=opt.get();
			 billRepository.delete(bill);
			 return bill;
		}
		else {
			throw new BillException("Bill not found with Id:"+billId);
		}
	}

	@Override
	public String generateBillById(int customerId) throws ItemException,CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> cOpt = customerRepository.findById(customerId);
		if(cOpt.isPresent()) {
			Customer customer = cOpt.get();
			List<Item> items = customer.getFoodcart().getItems();
			
			if(items.size() > 0) {
				
				Double total = 0.0;
				for(Item item : items) {
					total += (item.getCost()*item.getQuantity()); 
				}
				
				return "The total bill for "+customer.getFullName()+" is "+total;
				
			}else {
				throw new ItemException("No order items found for "+customer.getFullName());
			}
			
		}else {
			throw new CustomerException("No Customer found with ID: "+customerId);
		}
	}

}
