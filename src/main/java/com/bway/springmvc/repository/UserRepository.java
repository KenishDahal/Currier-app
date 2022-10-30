package com.bway.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springmvc.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsernameAndPassword(String un,String psw);

}
