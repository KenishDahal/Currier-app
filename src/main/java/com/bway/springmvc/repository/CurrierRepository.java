package com.bway.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springmvc.model.Currier;

public interface CurrierRepository extends JpaRepository<Currier, Integer>{
	
	
	//List<Currier> findById(int uid);
	
	

}
