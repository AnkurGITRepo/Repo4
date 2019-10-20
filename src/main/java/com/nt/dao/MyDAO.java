package com.nt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nt.entity.EmployeeEntity;

@Repository
public interface MyDAO extends JpaRepository<EmployeeEntity, Integer> {

	@Query(value = "select email from EmployeeEntity")
	public List<String> findAllUserEmails();

	@Query(value = "select email from EmployeeEntity where eNo = ?1")
	public String findEmailbyId(int id);
}
