package com.example.fooddeliveryproject.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddeliveryproject.auth.service.SignUpService;
import com.example.fooddeliveryproject.authexception.AuthorizationException;
import com.example.fooddeliveryproject.authmodels.SignUpEntity;

@RestController
@RequestMapping("/signup")
public class SignUpController {
	@Autowired
	private SignUpService signUpService;
	
	
	public SignUpController(SignUpService signUpService) {
		super();
		this.signUpService = signUpService;
	}


	@PostMapping("/signUp")
	public ResponseEntity<SignUpEntity> createNewSignUpHandler(@RequestBody SignUpEntity newSignUp) throws AuthorizationException {
		
		SignUpEntity newSignedUp =signUpService.newSignUpEntity(newSignUp);
		return new ResponseEntity<SignUpEntity>(newSignedUp,HttpStatus.CREATED);

	}
	
	
	@PutMapping("/updateSignUp")
	public ResponseEntity<SignUpEntity> updateSignUpDetailsHandler(@RequestBody SignUpEntity signUp, @RequestParam String key) throws AuthorizationException
	{
		SignUpEntity newUpdatedSignUp = signUpService.updateSignUp(signUp,key);
		
		return new ResponseEntity<SignUpEntity>(newUpdatedSignUp,HttpStatus.ACCEPTED);
		
	
	}
}
