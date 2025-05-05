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

import com.spring.vote.entity.Election_Entity;
import com.spring.vote.service.Election_Service;

@RestController
public class Election_Controller {
	@Autowired
	public Election_Service service;
	
	@GetMapping("/fetchallelections")
	public List<Election_Entity> getData(){
		return service.getAllElections();
	}
	
	@GetMapping("/fetchelectionbyid/{electionId}")
	public Optional<Election_Entity> getData(@PathVariable int electionId){
		return service.getElectionbyId(electionId);
	}
	
	@PostMapping("/createelectiondata")
	public Election_Entity createElectionData(@RequestBody Election_Entity data) {
		return service.saveElection(data);
	}
	
	@PutMapping("/updateelectiondata/{electionId}")
	public String updateVoteData(@RequestBody Election_Entity data,@PathVariable int electionId){
		return service.updateElectionData(data, electionId);
		
	}
	
	@DeleteMapping("/deleteelectiondata/{electionId}")
	public String deleteElectionData(@PathVariable int electionId) {
		return service.deleteById(electionId);
		
	}
}
