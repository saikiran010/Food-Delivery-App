package com.example.fooddeliveryproject.authexception;

@SuppressWarnings("serial")
public class AuthorizationException extends Exception{
	
	//private static final long serialVersionUID = 1L;

	public AuthorizationException() {
		// TODO Auto-generated constructor stub
	}
	
	public AuthorizationException(String message) {
		super(message);
	}

}
