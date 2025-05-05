package com.spring.vote.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.vote.entity.Voter_Entity;
import com.spring.vote.repository.Voter_Repository;

@Service
public class Voter_Service {

	@Autowired
	public Voter_Repository repo;
	
	//Create voter
	public Voter_Entity saveVoter(Voter_Entity data) {
		return repo.save(data);
	}
	
	//Get All Voters
	public List<Voter_Entity> getAllVoters() {
		return repo.findAll();
	}
	
	//Get Voter by Id
	public Optional<Voter_Entity> getVoterbyId(int id){
		return repo.findById(id);
	}

	
	//Delete Voter by Id
	public String deleteById(int id) {
		if(repo.existsById(id)) {
		  repo.deleteById(id);
		  return id+" data deleted Successfully!!";
		}
		else {
			return "Data not found :(";
		}
	}
	
	public String updateVoterData(Voter_Entity data, int empId) {
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
