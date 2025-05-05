package com.spring.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.vote.entity.SmtpEmail_Entity;

@Repository
public interface Smtpemail_Repository extends JpaRepository<SmtpEmail_Entity, Integer>{

}
