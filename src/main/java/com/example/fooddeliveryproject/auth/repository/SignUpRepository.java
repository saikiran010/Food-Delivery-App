package com.example.fooddeliveryproject.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddeliveryproject.authmodels.SignUpEntity;

public interface SignUpRepository extends JpaRepository<SignUpEntity, Integer> {

	//SignUpEntity findByUser(String signUp);

	Optional<SignUpEntity> findByUserName(String userName);



}
