package com.spring.vote.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.vote.entity.Admin_Entity;

public interface Admin_Repository extends JpaRepository<Admin_Entity, Integer> {

	List<Admin_Entity> findByAdminNameStartsWith(String adminName);

	List<Admin_Entity> findByAdminNameEndsWith(String adminName);

	List<Admin_Entity> findByAdminNameContaining(String adminName);

	boolean existsByAdminNameContaining(String adminName);

	List<Admin_Entity> findByAdminNameNotContains(String adminName);

	List<Admin_Entity> findByAdminNameLike(String adminName);

	List<Admin_Entity> findByAdminNameNotLike(String adminName);
	
	public Page<Admin_Entity> findAll(Pageable page);

}
