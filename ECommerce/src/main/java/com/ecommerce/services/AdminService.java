package com.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.models.Admin;
import com.ecommerce.models.LoginRequest;
import com.ecommerce.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;

	public String validateLogin(LoginRequest loginRequest) {
		
		Admin user = adminRepository.findByUsername(loginRequest.getUsername());
		        if((user.getPassword()).equals(loginRequest.getPassword())){
			          return "Authanticate";
		                }
		        else {
		        	return "UnAuthaticate";
		        }
	}
}
