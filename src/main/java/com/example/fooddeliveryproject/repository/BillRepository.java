package com.example.fooddeliveryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddeliveryproject.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {

	//Bill save(Optional<Bill> bill);

}
