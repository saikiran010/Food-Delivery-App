package com.example.fooddeliveryproject.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddeliveryproject.authmodels.UserSessionEntity;

public interface UserSessionRepository extends JpaRepository<UserSessionEntity, Integer> {

	static Optional<UserSessionEntity> findByUUID(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
