package com.example.fooddeliveryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddeliveryproject.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
