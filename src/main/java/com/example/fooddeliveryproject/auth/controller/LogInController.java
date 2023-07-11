package com.example.fooddeliveryproject.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddeliveryproject.auth.service.LogInServiceImpl;
import com.example.fooddeliveryproject.authexception.AuthorizationException;
import com.example.fooddeliveryproject.authmodels.LogInEntity;

@RestController
@RequestMapping("/login")
public class LogInController {

	@Autowired
	private LogInServiceImpl loginService;
	
	
	public LogInController(LogInServiceImpl loginService) {
		super();
		this.loginService = loginService;
	}

	@PostMapping("/login")
	public String loginHandler(@RequestBody LogInEntity loginData) throws AuthorizationException {
		return loginService.LogIn(loginData);
	}
	
	@PatchMapping("/logout")
	public String logOutFromAccount(@RequestParam String key) throws AuthorizationException
	{
		return loginService.LogOut(key);
	}
}
