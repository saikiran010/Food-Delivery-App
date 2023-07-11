package com.example.fooddeliveryproject.auth.service;

import com.example.fooddeliveryproject.authexception.AuthorizationException;
import com.example.fooddeliveryproject.authmodels.LogInEntity;

public interface LogInService {
	
	public String LogIn(LogInEntity login) throws AuthorizationException;
	
	public String LogOut(String key) throws AuthorizationException;


}
