package com.impelsys.demo.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impelsys.demo.model.Department;
import com.impelsys.demo.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {
	
	@Autowired
	DepartmentService deptService;
	
	@PostMapping(value="/")
	public Department saveDepartment(Department dept) {
		log.info("Inside SaveDepartment");
		System.out.println("In SaveDepartment()");
		return deptService.saveDepartment(dept);
	}
	
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") Integer id) {
		log.info("Inside getDepartment for id "+ id );
		return deptService.findDepartmentById(id);
	}
}
