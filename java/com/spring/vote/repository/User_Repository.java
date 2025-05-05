package com.spring.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.vote.entity.User_Entity;

public interface User_Repository extends JpaRepository<User_Entity,Integer> {
	public User_Entity findByUserEmail(String email);
}
