 package com.example.fooddeliveryproject.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String fullName;
	private Integer age;
	private String gender;
	private String moblieNumber;
	private String email;
		
	//@JoinColumn(name="id")
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@OneToOne(mappedBy= "customer",cascade = CascadeType.ALL)
	@JsonIgnore
	public  FoodCart foodcart;

	
	public Customer() {
		super();
	}


	public Customer(String fullName, Integer age, String gender, String moblieNumber, String email, Address address,
			FoodCart foodcart) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.moblieNumber = moblieNumber;
		this.email = email;
		this.address = address;
		this.foodcart = foodcart;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMoblieNumber() {
		return moblieNumber;
	}


	public void setMoblieNumber(String moblieNumber) {
		this.moblieNumber = moblieNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public FoodCart getFoodcart() {
		return foodcart;
	}


	public void setFoodcart(FoodCart foodcart) {
		this.foodcart = foodcart;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullName=" + fullName + ", age=" + age + ", gender=" + gender
				+ ", moblieNumber=" + moblieNumber + ", email=" + email + ", address=" + address + ", foodcart="
				+ foodcart + "]";
	}

	
	
}
