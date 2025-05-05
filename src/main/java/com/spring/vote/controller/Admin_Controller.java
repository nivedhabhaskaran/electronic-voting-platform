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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.vote.entity.Admin_Entity;
import com.spring.vote.service.Admin_Service;

@RestController
public class Admin_Controller {
	@Autowired
	public Admin_Service service;
	
	@GetMapping("/fetchalladmins")
	public List<Admin_Entity> getData(){
		return service.getAllAdmin();
	}
	
	@GetMapping("/fetchadminbyid/{adminId}")
	public Optional<Admin_Entity> getData(@PathVariable int adminId){
		return service.getAdminbyId(adminId);
	}
	
	@PostMapping("/createadmindata")
	public Admin_Entity createAdminData(@RequestBody Admin_Entity data) {
		return service.saveAdmin(data);
	}
	
	@PutMapping("/updateadmindata/{adminId}")
	public String updateAdminData(@RequestBody Admin_Entity data,@PathVariable int adminId){
		return service.updateAdminData(data, adminId);
		
	}
	
	@DeleteMapping("/deleteadmindata/{adminId}")
	public String deleteAdminData(@PathVariable int adminId) {
		return service.deleteById(adminId);
		
	}
	
	@GetMapping("/startswith")
	public List<Admin_Entity> fetchStartsWithRecords(@RequestParam String adminName){
		return service.fetchStartsWithRecords(adminName);
	}
	
	@GetMapping("/endswith")
	public List<Admin_Entity> fetchEndsWithRecords(@RequestParam String  adminName){
		return service.endsWithRecords(adminName);
	}
	
	@GetMapping("/contains")
	public List<Admin_Entity> fetchContainsRecords(@RequestParam String  adminName){
		return service.ContainsRecords(adminName);
	}
	
	@GetMapping("/iscontaining")
	public boolean fetchIsContaining(@RequestParam String  adminName){
		return service.fetchIsContaining(adminName);
	}
	
	@GetMapping("/notcontains")
    public List<Admin_Entity> fetchNotContainsRecords(@RequestParam String  adminName){
    	return service.fetchNotContainsRecords(adminName);
    }

    @GetMapping("/like")
    public List<Admin_Entity> fetchLikeRecords(@RequestParam String  adminName){
    	return service.fetchLikeRecords(adminName);
    }
    
    @GetMapping("/notlike")
    public List<Admin_Entity> fetchNotLikeRecords(@RequestParam String  adminName){
    	return service.fetchNotLikeRecords(adminName);
    }
    
    @GetMapping("/pagination")
	public List<Admin_Entity> fetchPageDetails(@RequestParam int pageno,@RequestParam int pagesize ,@RequestParam String adminnamesort){
		return service.fetchPage(pageno, pagesize, adminnamesort);
	}
	
	@PostMapping("/smtpemail")
	public String smtpEmail(@RequestParam String receiver,@RequestParam String subject,@RequestParam String mailBody) {
		return service.smtpEmail(receiver,subject,mailBody);
	}
	
}
