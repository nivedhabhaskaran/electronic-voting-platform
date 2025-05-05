package com.spring.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.vote.entity.Vote_Entity;

public interface Vote_Repository extends JpaRepository<Vote_Entity, Integer> {

}
