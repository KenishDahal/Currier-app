package com.bway.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springmvc.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findByFnameAndPassword(String fn ,String psw);

}
