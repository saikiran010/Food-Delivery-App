package com.example.fooddeliveryproject.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddeliveryproject.auth.repository.SignUpRepository;
import com.example.fooddeliveryproject.authexception.AuthorizationException;
import com.example.fooddeliveryproject.authmodels.SignUpEntity;

@Service
public class SignUpServiceImpl implements SignUpService {
	@Autowired
	private SignUpRepository signUpRepository;
	
	
	public SignUpServiceImpl() {
		super();
	}

	public SignUpServiceImpl(SignUpRepository signUpRepository) {
		super();
		this.signUpRepository = signUpRepository;
	}

	@Autowired
	private UserSessionService userLoginSession;
	
	
	 

	public SignUpServiceImpl(UserSessionService userLoginSession) {
		super();
		this.userLoginSession = userLoginSession;
	}

	@Override
	public SignUpEntity newSignUpEntity(SignUpEntity signUp) throws AuthorizationException {
		Optional<SignUpEntity> opt = signUpRepository.findByUserName(signUp.getUserName());
		if(opt.isPresent())
		{
			throw new AuthorizationException("User Already Exists..!!");
		}
		
		return signUpRepository.save(signUp);
	}

	@Override
	public SignUpEntity updateSignUp(SignUpEntity signUp, String key) throws AuthorizationException {
		SignUpEntity signUpDetails = userLoginSession.getSignUpDetails(key);
		
		if(signUpDetails == null)
		{
			throw new AuthorizationException("User not LoggedIn...!! Try To Login first..");
		}
		
		if(signUpDetails.getUserId() == signUp.getUserId())
			{
			signUpRepository.save(signUp);
			return signUp;
			}
		else
			throw new AuthorizationException("UserId not found..!!");
	}

}
