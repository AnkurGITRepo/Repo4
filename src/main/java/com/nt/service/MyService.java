package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.MyDAO;
import com.nt.entity.EmployeeEntity;
import com.nt.model.Employee;

@Service
public class MyService {
	@Autowired
	private MyDAO dao;

	public String saveEmployee(EmployeeEntity empEntity) {
		EmployeeEntity result = dao.save(empEntity);
		if (result != null)
			return "Saved with id=" + result.geteNo();
		else
			return "No saved";
	}

	public List<EmployeeEntity> getAllEmployee() {
		return dao.findAll();
	}

	public EmployeeEntity getByID(int id) {
		Optional<EmployeeEntity> emp = dao.findById(id);
		if (emp.isPresent())
			return emp.get();
		else
			return null;
	}

	public boolean deleteEmployee(EmployeeEntity emp) {
		int id = emp.geteNo();
		dao.delete(emp);
		Optional<EmployeeEntity> entity = dao.findById(id);
		if (!entity.isPresent())
			return true;
		else
			return false;
	}
	//========================
	public EmployeeEntity getUserByID(int id) {
		Optional<EmployeeEntity> emp=dao.findById(id);
		if(emp.isPresent())
		return emp.get();
		return null;
	}

	public List<String> findAllUserEmails() {
		return dao.findAllUserEmails();
	}

	public String findEmailbyId(int id) {
		return dao.findEmailbyId(id);
	}
	
	
}
