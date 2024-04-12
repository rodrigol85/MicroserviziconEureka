package com.example.controllers;




import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.EmployeeClient;
import com.example.models.Department;
import com.example.repositories.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	@PostMapping("/")
	public Department add(@RequestBody Department department) {
		LOGGER.info("Department add: {}", department);
		return departmentRepo.addDepartment(department);
	}
	
	@GetMapping
	public List<Department> findAll(){
		LOGGER.info("Department find: ");
		return departmentRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable Long id) {
		LOGGER.info("Department find: id={}", id);
		return departmentRepo.findById(id);
	}
	
	@GetMapping("/with-employees")
	public List<Department> findAllWithEmployees(){
		LOGGER.info("Department find: ");
		List<Department> departments = departmentRepo.findAll();
		departments.forEach(department -> department.setEmployees(employeeClient.findByDepartment(department.getId())));
		return departments;
	}

}
