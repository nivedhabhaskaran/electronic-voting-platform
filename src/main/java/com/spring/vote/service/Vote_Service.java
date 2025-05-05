package com.spring.vote.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.vote.entity.Vote_Entity;
import com.spring.vote.repository.Vote_Repository;

@Service
public class Vote_Service {
	@Autowired
	public Vote_Repository repo;
	
	//Create vote
	public Vote_Entity saveVote(Vote_Entity data) {
		return repo.save(data);
	}
	
	//Get All Votes
	public List<Vote_Entity> getAllVotes() {
		return repo.findAll();
	}
	
	//Get Vote by Id
	public Optional<Vote_Entity> getVotebyId(int id){
		return repo.findById(id);
	}

	
	//Delete Vote by Id
	public String deleteById(int id) {
		if(repo.existsById(id)) {
		  repo.deleteById(id);
		  return id+" data deleted Successfully!!";
		}
		else {
			return "Data not found :(";
		}
	}
	
	public String updateVoteData(Vote_Entity data, int empId) {
		if(repo.existsById(empId)) {
	    	repo.save(data);
	    	return data+" Data updated successfully!!!";
	    	}
	    	else {
	    		return data+" Data can't be updated ;(";
	    	}
	}
	
	//to check/ensure establish of mysql connectivity 
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
}
