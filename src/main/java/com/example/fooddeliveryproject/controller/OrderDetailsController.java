package com.example.fooddeliveryproject.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddeliveryproject.auth.service.UserSessionService;
import com.example.fooddeliveryproject.authexception.AuthorizationException;
import com.example.fooddeliveryproject.entity.Item;
import com.example.fooddeliveryproject.entity.OrderDetails;
import com.example.fooddeliveryproject.exception.CustomerException;
import com.example.fooddeliveryproject.exception.OrderException;
import com.example.fooddeliveryproject.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderDetailsController {

	private OrderService orderService;
	@Autowired
	public OrderDetailsController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	@Autowired
	UserSessionService userSessionService;
	

	 public OrderDetailsController(OrderService orderService, UserSessionService userSessionService) {
		super();
		this.orderService = orderService;
		this.userSessionService = userSessionService;
	}


	@PostMapping("/save")
     public ResponseEntity<OrderDetails> saveOrder(@RequestBody OrderDetails order, @RequestParam String key) throws OrderException, AuthorizationException{
     	
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return new ResponseEntity<OrderDetails>(orderService.addOrder(order), HttpStatus.CREATED);
     	else
     		throw new OrderException();
     }
	
	
	 @PutMapping("/update")
     public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetails order, @RequestParam String key) throws OrderException, AuthorizationException{
         
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return new ResponseEntity<OrderDetails>(orderService.updateOrder(order), HttpStatus.ACCEPTED);
     	else
     		throw new OrderException();
     		
     }
     
	
	 
	 @DeleteMapping("/remove/{orderId}")
    public ResponseEntity<OrderDetails> deleteOrder(@PathVariable("orderId") Integer orderId , @RequestParam String key) throws OrderException, AuthorizationException{
    	
    	Integer sessionId = userSessionService.getUserSessionId(key);
    	
    	if(sessionId != null) 
    		return new ResponseEntity<OrderDetails>(orderService.removeOrder(orderId), HttpStatus.ACCEPTED);
    	
    	else
    		throw new OrderException();
    }

 
	 @GetMapping("/view/{orderId}")
    public ResponseEntity<OrderDetails> viewOrder(@PathVariable("orderId") Integer orderId) throws OrderException, AuthorizationException{
    	
    	 
    	
    	 
    		return  new ResponseEntity<OrderDetails>(orderService.viewOrder(orderId),HttpStatus.FOUND);
	 }


	 @GetMapping("/viewbycustomer/{customerId}")
     public ResponseEntity<List<Item>> viewAllOrders(@PathVariable("customerId") Integer customerId) throws OrderException, CustomerException, AuthorizationException{


     
     		return  new ResponseEntity<List<Item>>(orderService.viewAllOrdersByCustomer(customerId), HttpStatus.FOUND);
    
     }
	 
	 /*
	  * 	 @GetMapping("/view/{orderId}")
    public ResponseEntity<OrderDetails> viewOrder(@PathVariable("orderId") Integer orderId,@RequestParam String key) throws OrderException, AuthorizationException{
    	
    	Integer sessionId = userSessionService.getUserSessionId(key);
    	
    	if(sessionId != null)
    		return  new ResponseEntity<OrderDetails>(orderService.viewOrder(orderId),HttpStatus.FOUND);
    	else
    		throw new OrderException();
    }


	 @GetMapping("/viewbycustomer/{customerId}")
     public ResponseEntity<List<Item>> viewAllOrders(@PathVariable("customerId") Integer customerId,@RequestParam String key) throws OrderException, CustomerException, AuthorizationException{
     	
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return  new ResponseEntity<List<Item>>(orderService.viewAllOrdersByCustomer(customerId), HttpStatus.FOUND);
     	else
     		throw new OrderException();
     }
	  */
	 
}
