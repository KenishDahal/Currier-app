package com.bway.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springmvc.model.Pending;

public interface PendingRepository extends JpaRepository<Pending, Integer>{

	
}
