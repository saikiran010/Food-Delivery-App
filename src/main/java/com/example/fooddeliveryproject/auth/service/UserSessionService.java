package com.example.fooddeliveryproject.auth.service;

import com.example.fooddeliveryproject.authexception.AuthorizationException;
import com.example.fooddeliveryproject.authmodels.SignUpEntity;
import com.example.fooddeliveryproject.authmodels.UserSessionEntity;

public interface UserSessionService {
	
	public UserSessionEntity getUserSession(String key) throws AuthorizationException;
	
	public Integer getUserSessionId(String key) throws AuthorizationException;
	
	public SignUpEntity getSignUpDetails(String key) throws AuthorizationException;
	 
}
