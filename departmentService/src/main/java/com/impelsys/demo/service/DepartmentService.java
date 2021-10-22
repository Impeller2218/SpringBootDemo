package com.impelsys.demo.service;

import org.springframework.stereotype.Service;

import com.impelsys.demo.model.Department;
import com.impelsys.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	DepartmentRepository deptRepo;

	public Department saveDepartment(Department dept) {
	
		
		return deptRepo.save(dept);
		// TODO Auto-generated method stub
		
	}


	public Department findDepartmentById(Integer id) {
		// TODO Auto-generated method stub
		return deptRepo.getById(id);
	}
}
