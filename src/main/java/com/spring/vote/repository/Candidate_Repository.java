package com.spring.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.vote.entity.Candidate_Entity;

public interface Candidate_Repository extends JpaRepository<Candidate_Entity, Integer> {


}
