package com.ecommerce.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.models.LoginRequest;
import com.ecommerce.models.User;
import com.ecommerce.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
   
	public boolean validateLogin(LoginRequest loginRequest) {
		
			User user = userRepository.findByUsername(loginRequest.getUsername());
			        if(user.getPassword().equals(loginRequest.getPassword())){
				return true;
			}
			        else {
			        	return false;
			        }
		}
	
	
	public void save(User user) { 
		userRepository.save(user);
	}


	public List<User> getAllusers() {
		return userRepository.findAll();
	}


//	public void deleteUser(long id) {
//		
//		userRepository.deleteById(id);
//	}
	
       public void deleteUser(long id) {
		
    	   User user = userRepository.findById(id);
    	   userRepository.delete(user);
	}


	public String getUserName(HttpServletRequest res) {
		Cookie[] cookies = res.getCookies();
		String name = null;
		if(cookies == null) {
			return name;
		}
		else {
			for(Cookie c : cookies) {
				String key = c.getName();
				if(key.equals("username")) {
					name = c.getValue();
				}
			}
		}
		return name;
	}


	public void logoutUser(String userName,HttpServletResponse response) {
		Cookie cookie = new Cookie("username",userName);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
	}


	public User getUser(String username) {
		
		User user = userRepository.findByUsername(username);
		return user;
	}
	
	
}
