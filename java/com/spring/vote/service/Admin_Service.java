package com.spring.vote.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.spring.vote.entity.Admin_Entity;
import com.spring.vote.entity.SmtpEmail_Entity;
import com.spring.vote.repository.Admin_Repository;
import com.spring.vote.repository.Smtpemail_Repository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class Admin_Service {
	@Autowired
	public Admin_Repository repo;
	
	@Autowired
	JavaMailSender sender;
	
	@Autowired
	public Smtpemail_Repository smtprepo;
	
	//Create Admin
	public Admin_Entity saveAdmin(Admin_Entity data) {
		return repo.save(data);
	}
	
	//Get All Admin
	public List<Admin_Entity> getAllAdmin() {
		return repo.findAll();
	}
	
	//Get Admin by Id
	public Optional<Admin_Entity> getAdminbyId(int id){
		return repo.findById(id);
	}

	
	//Delete Admin by Id
	public String deleteById(int id) {
		if(repo.existsById(id)) {
		  repo.deleteById(id);
		  return id+" data deleted Successfully!!";
		}
		else {
			return "Data not found :(";
		}
	}
	
	public String updateAdminData(Admin_Entity data, int adminId) {
		if(repo.existsById(adminId)) {
	    	repo.save(data);
	    	return data+" Data updated successfully!!!";
	    	}
	    	else {
	    		return data+" Data can't be updated ;(";
	    	}
	}
	
//	to check & ensure establish of mysql connectivity 
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

	public List<Admin_Entity> fetchStartsWithRecords(String adminName) {
		return repo.findByAdminNameStartsWith(adminName);
	}

	public List<Admin_Entity> endsWithRecords(String adminName) {
		return repo.findByAdminNameEndsWith(adminName);
	}

	public List<Admin_Entity> ContainsRecords(String adminName) {
		return repo.findByAdminNameContaining(adminName);
	}

	public boolean fetchIsContaining(String adminName) {
		return repo.existsByAdminNameContaining(adminName);
	}

	public List<Admin_Entity> fetchNotContainsRecords(String adminName) {
		return repo.findByAdminNameNotContains(adminName);
	}

	public List<Admin_Entity> fetchLikeRecords(String adminName) {
		return repo.findByAdminNameLike(adminName);
	}

	public List<Admin_Entity> fetchNotLikeRecords(String adminName) {
		return repo.findByAdminNameNotLike(adminName);
	}

	public List<Admin_Entity> fetchPage(int pageno, int pagesize, String adminnamesort) {

		Pageable page = PageRequest.of(pageno, pagesize, Sort.by(adminnamesort).ascending());
		//PageRequest is a class. Inside the class, "of" is a method used to pass the data
		//pageno, pagesize, and the column (based on which) and order to be sorted will be stored in "page" obj
		return repo.findAll(page).getContent();
	}

	public String smtpEmail(String receiver, String subject, String mailBody) {
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message);
			
			messageHelper.setTo(receiver);
			messageHelper.setSubject(subject);
			messageHelper.setText(mailBody);
			
			sender.send(message);
			
			SmtpEmail_Entity smtp = new SmtpEmail_Entity();
			smtp.setReceiver(receiver);
			smtp.setSubject(subject);
			smtp.setContent(mailBody);
			smtprepo.save(smtp);
			
			return "Mail sent successfully :)";
			
		}
		catch(MessagingException e) {
			return "Mail not sent :( "+e.getMessage();
		}
	}
}
