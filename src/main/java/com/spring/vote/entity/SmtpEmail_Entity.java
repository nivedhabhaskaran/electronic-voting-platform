package com.spring.vote.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="smtpemail_data")
@Data
public class SmtpEmail_Entity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="receiver")
	private String receiver;
	@Column(name="subject")
	private String subject;
	@Column(name="content")
	private String content;
	
	
}
