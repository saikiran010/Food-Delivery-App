package com.example.fooddeliveryproject.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class FoodCart {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int cartId;
   
   @OneToOne(cascade = CascadeType.ALL)
   @JsonIgnore
   private Customer customer;
   @OneToMany(targetEntity = Item.class,cascade = CascadeType.ALL)
   private List<Item> items;
   
   public FoodCart() {
		super();
   }
	
	public FoodCart(int cartId, Customer customer, List<Item> items) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.items = items;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "FoodCart [cartId=" + cartId + ", customer=" + customer + ", items=" + items + "]";
	}
	
}
