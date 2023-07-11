package com.example.fooddeliveryproject.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddeliveryproject.authmodels.LogInEntity;

public interface LogInRepository extends JpaRepository<LogInEntity, Integer> {

}
