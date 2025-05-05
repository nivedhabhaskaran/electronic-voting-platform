package com.spring.vote.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="admin_data")
public class Admin_Entity {
	@Id
    @Column(name = "adminId")
    private int adminId;

    @Column(name = "adminEmail", nullable = false, unique = true)
    private String adminEmail;

    @Column(name = "adminName", nullable = false)
    private String adminName;

  
}
