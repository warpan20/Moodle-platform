package com.moodle.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moodle.app.exception.ResourceNotFoundException;
import com.moodle.app.model.Student;
import com.moodle.app.repository.StuRepo;
import com.moodle.app.service.StuService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class  StuController {
    
	//Dependency Injection
	@Autowired
	private StuService stu_service;
	
	
	@PostMapping("/addStudent")
	public Student saveStud(@RequestBody Student stu) {
		return stu_service.saveStudent(stu);
	}
	
	@GetMapping("/getStudents")
	public List<Student> findallStud() {
		return stu_service.getAllStudents();
	}
	
	@GetMapping("/getStudent/{id}")
	public Student findStudById(@PathVariable int id) throws ResourceNotFoundException {
		return stu_service.getStudentById(id);
	}
	//check this method       
	@PutMapping("/updateStudent/{id}")
	public Student updateStud( @PathVariable int id,@RequestBody Student stud)throws ResourceNotFoundException {
	      return stu_service.updateStudent(id,stud);
	     
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStud(@PathVariable int id) {
		return stu_service.deleteStudent(id);
	}
	@GetMapping("/getStudentByUsername/{user}")
	public Student findStudByUsername(@PathVariable String user) {
		return stu_service.getStudentByUsername(user);
	}
	
	
}

