package com.spring.vote.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.vote.entity.User_Entity;
import com.spring.vote.service.User_Service;

@RestController
@RequestMapping("/auth")
public class User_Controller {
	
	@Autowired
	public User_Service service;
	
//	http://localhost:8080/auth/login
	@PostMapping("/login")
	public String userLogin(@RequestBody LoginRequest loginRequest) {
	    return service.loginUser(loginRequest.getEmail(),loginRequest.getPassword());
	}

	@GetMapping("/fetchallusers")
	public List<User_Entity> getData(){
		return service.getAllUsers();
	}
	
	@GetMapping("/fetchuserbyid/{userId}")
	public Optional<User_Entity> getDataById(@PathVariable int userId){
		return service.getuserbyId(userId);
	}
	
	@Transactional
	@PostMapping("/createuserdata")
	public User_Entity createUserData(@RequestBody User_Entity data) {
		return service.saveUser(data);
	}
	
	@PutMapping("/updateuserdata/{userId}")
	public String updateUserData(@RequestBody User_Entity data,@PathVariable int userId){
		return service.updateUserData(data, userId);
		
	}
	
	@DeleteMapping("/deleteuserdata/{userId}")
	public String deleteUserData(@PathVariable int userId) {
		return service.deleteById(userId);
		
	}
	
	
}
