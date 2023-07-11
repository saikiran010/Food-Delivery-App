package com.example.fooddeliveryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddeliveryproject.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
