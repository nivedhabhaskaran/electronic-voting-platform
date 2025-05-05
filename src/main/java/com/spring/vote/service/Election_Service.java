package com.spring.vote.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.vote.entity.Election_Entity;
import com.spring.vote.repository.Election_Repository;

@Service
public class Election_Service {
	@Autowired
	public Election_Repository repo;
	
	//Create Election
	public Election_Entity saveElection(Election_Entity data) {
		return repo.save(data);
	}
	
	//Get All Election
	public List<Election_Entity> getAllElections() {
		return repo.findAll();
	}
	
	//Get Election by Id
	public Optional<Election_Entity> getElectionbyId(int id){
		return repo.findById(id);
	}

	
	//Delete Election by Id
	public String deleteById(int id) {
		if(repo.existsById(id)) {
		  repo.deleteById(id);
		  return id+" data deleted Successfully!!";
		}
		else {
			return "Data not found :(";
		}
	}
	
	public String updateElectionData(Election_Entity data, int electionId) {
		if(repo.existsById(electionId)) {
	    	repo.save(data);
	    	return data+" Data updated successfully!!!";
	    	}
	    	else {
	    		return data+" Data not found :(";
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
