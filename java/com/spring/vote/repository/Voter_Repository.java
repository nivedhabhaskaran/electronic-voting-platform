package com.spring.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.vote.entity.Voter_Entity;

public interface Voter_Repository extends JpaRepository<Voter_Entity, Integer> {
	
	public Voter_Entity findByVoterEmail(String email);


}
