package com.example.fooddeliveryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddeliveryproject.entity.OrderDetails;

public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

}
