package com.spring.vote.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.vote.entity.Candidate_Entity;
import com.spring.vote.service.Candidate_Service;

@RestController
public class Candidate_Controller {
	@Autowired
	public  Candidate_Service service;
	
	@GetMapping("/fetchallcandidates")
	public List<Candidate_Entity> getData(){
		return service.getAllCandidates();
	}
	
	@GetMapping("/fetchcandidatebyid/{candidateId}")
	public Optional<Candidate_Entity> getData(@PathVariable int candidateId){
		return service.getCandidatebyId(candidateId);
	}
	
	@PostMapping("/createcandidatedata")
	public Candidate_Entity createCandidateData(@RequestBody Candidate_Entity data) {
		return service.saveCandidate(data);
	}
	
	@PutMapping("/updatecandidatedata/{candidateId}")
	public String updateCandidateData(@RequestBody Candidate_Entity data,@PathVariable int candidateId){
		return service.updateCandidateData(data, candidateId);
		
	}
	
	@DeleteMapping("/deletecandidatedata/{candidateId}")
	public String deleteCandidateData(@PathVariable int candidateId) {
		return service.deleteById(candidateId);
		
	}
	
	@PostMapping("/manyTomany")
	public Candidate_Entity getManyToMany(@RequestBody Candidate_Entity table) {
		return service.candidateElection(table);
	}
}
