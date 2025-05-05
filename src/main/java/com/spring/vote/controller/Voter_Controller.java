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

import com.spring.vote.entity.Voter_Entity;
import com.spring.vote.service.Voter_Service;

@RestController
public class Voter_Controller {
	@Autowired
	public Voter_Service service;
	
	
	@GetMapping("/fetchallvoters")
	public List<Voter_Entity> getData(){
		return service.getAllVoters();
	}
	
	@GetMapping("/fetchvoterbyid/{voterId}")
	public Optional<Voter_Entity> getDataById(@PathVariable int voterId){
		return service.getVoterbyId(voterId);
	}
	
	@PostMapping("/createvoterdata")
	public Voter_Entity createVoterData(@RequestBody Voter_Entity data) {
		return service.saveVoter(data);
	}
	
	@PutMapping("/updatevoterdata/{voterId}")
	public String updateVoterData(@RequestBody Voter_Entity data,@PathVariable int voterId){
		return service.updateVoterData(data, voterId);
		
	}
	
	@DeleteMapping("/deletevoterdata/{voterId}")
	public String deleteVoterData(@PathVariable int voterId) {
		return service.deleteById(voterId);
		
	}
	
}
