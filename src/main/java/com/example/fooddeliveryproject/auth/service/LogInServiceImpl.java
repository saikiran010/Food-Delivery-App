package com.example.fooddeliveryproject.auth.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddeliveryproject.auth.repository.LogInRepository;
import com.example.fooddeliveryproject.auth.repository.SignUpRepository;
import com.example.fooddeliveryproject.auth.repository.UserSessionRepository;
import com.example.fooddeliveryproject.authexception.AuthorizationException;
import com.example.fooddeliveryproject.authmodels.LogInEntity;
import com.example.fooddeliveryproject.authmodels.SignUpEntity;
import com.example.fooddeliveryproject.authmodels.UserSessionEntity;

@Service
public class LogInServiceImpl implements LogInService {

	@Autowired
	private SignUpRepository signUpRepository;
	
	@Autowired
	private UserSessionRepository userSessionRepository;
	
	
	@Autowired
	private LogInRepository loginRepository;
	
	
	public LogInServiceImpl(SignUpRepository signUpRepository, UserSessionRepository userSessionRepository,
			LogInRepository loginRepository) {
		super();
		this.signUpRepository = signUpRepository;
		this.userSessionRepository = userSessionRepository;
		this.loginRepository = loginRepository;
	}

	@Override
	public String LogIn(LogInEntity login) throws AuthorizationException {
		
		Optional<SignUpEntity> opt = signUpRepository.findById(login.getUserId());
		if(!opt.isPresent())
		{
			throw new AuthorizationException("Invalid Login UserId");
		}
		
		SignUpEntity newSignUp = opt.get();
		
		Integer newSignUpId = newSignUp.getUserId();
		Optional<UserSessionEntity> currentUserOptional = userSessionRepository.findById(newSignUpId);
		
		if(currentUserOptional.isPresent()) {
			throw new AuthorizationException("User Already LoggedIn with this UserId");
		}
		if((newSignUp.getUserId() == login.getUserId()) && (newSignUp.getPassword().equals(login.getPassword())))
		{
			String key = new String();
			
			UserSessionEntity currentUserSession = new UserSessionEntity(newSignUp.getUserId(),key,LocalDateTime.now());
			userSessionRepository.save(currentUserSession);
			loginRepository.save(login);
			
			return currentUserSession.toString();
			
		}
		else
			throw new AuthorizationException("Invalid UserName or Password..");
			
				
	}

	@Override
	public String LogOut(String key) throws AuthorizationException {
		// TODO Auto-generated method stub
		Optional<UserSessionEntity> currentUserOptional = userSessionRepository.findById(null);
		if(!currentUserOptional.isPresent())
		{
			throw new AuthorizationException("Invalid credentials...");
		}
		UserSessionEntity currentUserSession = UserSessionEntity.getUserSessionEntity(key);
		
		userSessionRepository.delete(currentUserSession);
		
		Optional<LogInEntity> login = loginRepository.findById(currentUserOptional.get().getUserId());
		System.out.println(login);
		loginRepository.delete(login.get());
		
	
		return "Logged Out...";
	}
	

}
