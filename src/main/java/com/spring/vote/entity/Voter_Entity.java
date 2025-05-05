package com.spring.vote.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="voter_data")
public class Voter_Entity {
	    @Id
	    @Column(name = "voterId")
	    private int voterId;

	    @Column(name = "voterName", nullable = false)
	    private String voterName;

	    @Column(name = "voterAge", nullable = false)
	    private int voterAge;

	    @Column(name = "voterEmail", nullable = false, unique = true)
	    private String voterEmail;

	    @Column(name = "voterPassword", nullable = false)
	    private String password;
	    
	    @OneToOne
	    @JoinColumn(name="voteId")
	    public Vote_Entity vote;
}
