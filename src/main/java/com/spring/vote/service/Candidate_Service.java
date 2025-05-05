package com.spring.vote.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.vote.entity.Candidate_Entity;
import com.spring.vote.entity.Election_Entity;
import com.spring.vote.repository.Candidate_Repository;
import com.spring.vote.repository.Election_Repository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class Candidate_Service {
	@Autowired
	public Candidate_Repository repo;
	
	//Create candidate
	public Candidate_Entity saveCandidate(Candidate_Entity data) {
		return repo.save(data);
	}
	
	//Get All Candidates
	public List<Candidate_Entity> getAllCandidates() {
		return repo.findAll();
	}
	
	//Get Candidate by Id
	public Optional<Candidate_Entity> getCandidatebyId(int id){
		return repo.findById(id);
	}

	
	//Delete Candidate by Id
	public String deleteById(int id) {
		if(repo.existsById(id)) {
		  repo.deleteById(id);
		  return id+" data deleted Successfully!!";
		}
		else {
			return "Data not found :(";
		}
	}
	
	public String updateCandidateData(Candidate_Entity data, int candidateId) {
		if(repo.existsById(candidateId)) {
	    	repo.save(data);
	    	return data+" Data updated successfully!!!";
	    	}
	    	else {
	    		return data+" Data can't be updated ;(";
	    	}
	}
	
	//to check & ensure establish of mysql connectivity 
    public static void main(String[] args) {
    	String url = "jdbc:mysql://localhost:3306/employee_details";
    	String username = "root" ;
    	String password = "niv@2006@n15";  
    	
    	try(Connection con = DriverManager.getConnection(url, username, password)) {
    		if(con!=null) {
    			System.out.print("Connection established successfully!!!");
    		}
    		else {
    			System.out.print("Failed to connect db");
    		}
    	}
    	catch(SQLException e) {
    		System.out.print("Connection failed"+e.getMessage());
    	}
    		
    }
    
    @Autowired
    Candidate_Repository crepo;
    
    @Autowired
    Election_Repository erepo;
    
//    @Transactional
//	public Candidate_Entity candidateElection(Candidate_Entity table) {
//		
//		Election_Entity election = erepo.findById(table.getElec().get(0).
//				getElectionId()).orElse(null);
//		if(election!=null) {
//			List<Election_Entity> existingElections = table.getElec();
//	        if (existingElections == null) {
//	            existingElections = new ArrayList<>();
//	        }
//	        
//	        // Add the found election instead of replacing
//	        existingElections.add(election);
//	        table.setElec(existingElections);
//		}
//		return crepo.save(table);
//		
//	}
//    @Transactional
//    public Candidate_Entity candidateElection(Candidate_Entity table) {
//        if (table.getElec() == null || table.getElec().isEmpty()) {
//            throw new IllegalArgumentException("No election provided in request.");
//        }
//
//        Election_Entity election = erepo.findById(table.getElec().get(0).getElectionId()).orElse(null);
//        if (election == null) {
//            throw new EntityNotFoundException("Election not found in database.");
//        }
//
//        table.getElec().add(election); 
//        return crepo.save(table);
//    }
    @Transactional
    public Candidate_Entity candidateElection(Candidate_Entity table) {
        Election_Entity election = erepo.findById(table.getElec().get(0).getElectionId()).orElse(null);
        if (election != null) {
            if (table.getElec() == null) {
                table.setElec(new ArrayList<>()); // Initialize if null
            }
            table.getElec().add(election); // Add new election instead of replacing
        }
        return crepo.save(table);
    }



}
