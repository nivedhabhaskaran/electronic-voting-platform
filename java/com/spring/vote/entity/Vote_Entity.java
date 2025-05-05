package com.spring.vote.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="vote_data")
public class Vote_Entity {
	@Id
	@Column(name="voteId")
	private int voteId;
	@Column(name="voterId")
	private int voterId;

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="candidateId")
	public Candidate_Entity candidate;
	
	
	
 
}
