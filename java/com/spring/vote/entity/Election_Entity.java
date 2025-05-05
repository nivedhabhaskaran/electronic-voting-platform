package com.spring.vote.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="election_data")
public class Election_Entity {
	    @Id
	    @Column(name = "electionId")
	    private int electionId;

	    @Column(name = "electionStatus", nullable = false)
	    private String electionStatus;

	    @Column(name = "startDate", nullable = false)
	    private String startDate;

	    @Column(name = "endDate", nullable = false)
	    private String endDate;
	    
	    @ManyToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="adminId")
	    public Admin_Entity admin;
	    
	    @ManyToMany(mappedBy = "elec")
	    private List<Candidate_Entity> candidates;

	    
//	    @OneToMany(cascade=CascadeType.ALL)
//	    @JoinColumn(name="candidateId")
//	    public List<Candidate_Entity> candidate;
//	    
//	    
	    
}
