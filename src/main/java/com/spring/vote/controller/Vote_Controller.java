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

import com.spring.vote.entity.Vote_Entity;
import com.spring.vote.service.Vote_Service;

@RestController
public class Vote_Controller {
	@Autowired
	public Vote_Service service;
	
	@GetMapping("/fetchallvotes")
	public List<Vote_Entity> getData(){
		return service.getAllVotes();
	}
	
	@GetMapping("/fetchvotebyid/{voteId}")
	public Optional<Vote_Entity> getData(@PathVariable int voteId){
		return service.getVotebyId(voteId);
	}
	
	@PostMapping("/createvotedata")
	public Vote_Entity createVoteData(@RequestBody Vote_Entity data) {
		return service.saveVote(data);
	}
	
	@PutMapping("/updatevotedata/{voteId}")
	public String updateVoteData(@RequestBody Vote_Entity data,@PathVariable int voteId){
		return service.updateVoteData(data, voteId);
		
	}
	
	@DeleteMapping("/deletevotedata/{voteId}")
	public String deleteVoteData(@PathVariable int voteId) {
		return service.deleteById(voteId);
		
	}
	
}
