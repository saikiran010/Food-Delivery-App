package com.example.fooddeliveryproject.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddeliveryproject.auth.repository.SignUpRepository;
import com.example.fooddeliveryproject.auth.repository.UserSessionRepository;
import com.example.fooddeliveryproject.authexception.AuthorizationException;
import com.example.fooddeliveryproject.authmodels.SignUpEntity;
import com.example.fooddeliveryproject.authmodels.UserSessionEntity;

@Service
public class UserSessionServiceImpl implements UserSessionService {
	@Autowired
	private SignUpRepository signUpRepository;
	
	public UserSessionServiceImpl(SignUpRepository signUpRepository) {
		super();
		this.signUpRepository = signUpRepository;
	}

	@Override
	public UserSessionEntity getUserSession(String key) throws AuthorizationException {
		Optional<UserSessionEntity> currentUser = UserSessionRepository.findByUUID(key);
		if(!currentUser.isPresent())
		{
			throw new AuthorizationException("Not Authorized..!!");
		}
		return currentUser.get();
	}

	@Override
	public Integer getUserSessionId(String key) throws AuthorizationException {
		Optional<UserSessionEntity> currentUser = UserSessionRepository.findByUUID(key);
		if(!currentUser.isPresent())
		{
			throw new AuthorizationException("Not Authorized..!!");
		}
		return currentUser.get().getId();
	}

	@Override
	public SignUpEntity getSignUpDetails(String key) throws AuthorizationException {
		Optional<UserSessionEntity> currentUser = UserSessionRepository.findByUUID(key);
		if(!currentUser.isPresent())
		{
			return null;
		}
		Integer SignUpUserId = currentUser.get().getUserId();
		System.out.println(SignUpUserId );
		
		return (signUpRepository.findById(SignUpUserId)).get();
	}

}
