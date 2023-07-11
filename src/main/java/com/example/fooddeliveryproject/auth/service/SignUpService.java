package com.example.fooddeliveryproject.auth.service;

import com.example.fooddeliveryproject.authexception.AuthorizationException;
import com.example.fooddeliveryproject.authmodels.SignUpEntity;

public interface SignUpService {
	
	public SignUpEntity newSignUpEntity (SignUpEntity  signUp) throws AuthorizationException;
	
	public SignUpEntity updateSignUp(SignUpEntity signUp, String key) throws AuthorizationException;

}
