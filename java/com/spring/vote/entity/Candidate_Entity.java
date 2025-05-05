package com.spring.vote.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="candidate_data")
public class Candidate_Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "candidateId")
    private int candidateId;

    @Column(name = "candidateName", nullable = false)
    private String candidateName;

    @Column(name = "partyName", nullable = false)
    private String partyName;

    @Column(name = "totalVotes", nullable = false)
    private int totalVotes;
    
    @ManyToMany(cascade= CascadeType.PERSIST)
    @JoinTable(name="Electioncandidates",
    joinColumns=@JoinColumn(name="candidateId"),
    inverseJoinColumns=@JoinColumn(name="electionId"))
    private List<Election_Entity> elec;
    
		
}
