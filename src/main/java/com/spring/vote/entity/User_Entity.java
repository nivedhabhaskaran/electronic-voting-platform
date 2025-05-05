package com.spring.vote.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="user_data")

public class User_Entity {
	@Id
	@Column(name="userId")
	private int Id;
	@Column(name="Email")
	private String userEmail;	
	@Column(name="userPassword")
	private String password;
	@Column(name="userRole")
	private String role;
	
	@OneToOne
	@JoinColumn(name="voterId")
	public Voter_Entity voter;
}
