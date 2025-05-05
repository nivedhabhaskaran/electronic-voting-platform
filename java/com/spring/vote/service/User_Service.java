package com.spring.vote.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.vote.entity.User_Entity;
import com.spring.vote.repository.User_Repository;
import com.spring.vote.security.SecurityConfig;

@Service
public class User_Service {
	
	@Autowired
	public User_Repository repo;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

	public String loginUser(String email, String password) {
	    User_Entity user = repo.findByUserEmail(email);
	    
	    if (user == null) {
	        return "Invalid credentials";
	    }

	    // Compare the raw password with the stored hashed password
	    if (passwordEncoder.matches(password, user.getPassword())) {
	        return "Login successful";
	    } else {
	        return "Invalid credentials";
	    }
	}


	public List<User_Entity> getAllUsers() {
		return repo.findAll();
	}

	public Optional<User_Entity> getuserbyId(int userId) {
		return repo.findById(userId);
	}

	public User_Entity saveUser(User_Entity data) {
		data.setPassword(passwordEncoder.encode(data.getPassword()));
		return repo.save(data);
	}

	public String updateUserData(User_Entity data, int userId) {
	    if (repo.existsById(userId)) {
	        User_Entity existingUser = repo.findById(userId).orElse(null);
	        
	        if (existingUser != null) {
	            // Preserve old hashed password if new password is empty
	            if (data.getPassword() == null || data.getPassword().isEmpty()) {
	                data.setPassword(existingUser.getPassword());
	            } else {
	                // Rehash only if password is modified
	                data.setPassword(passwordEncoder.encode(data.getPassword()));
	            }

	            repo.save(data);
	            return "Data updated successfully!!!";
	        }
	    }
	    return "Data can't be updated ;(";
	}


	public String deleteById(int userId) {
		if(repo.existsById(userId)) {
			  repo.deleteById(userId);
			  return userId+" data deleted Successfully!!";
			}
			else {
				return "Data not found :(";
			}
	}
	
	

}
