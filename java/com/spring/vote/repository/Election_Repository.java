package com.spring.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.vote.entity.Election_Entity;

public interface Election_Repository extends JpaRepository<Election_Entity, Integer> {
	
}
