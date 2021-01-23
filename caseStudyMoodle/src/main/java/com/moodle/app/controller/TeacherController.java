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
import org.springframework.web.bind.annotation.RestController;

import com.moodle.app.exception.ResourceNotFoundException;
import com.moodle.app.model.Teacher;
import com.moodle.app.service.TeacherService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class TeacherController {

	//Dependency Injection
	@Autowired
	private TeacherService teach_service;
	
	@PostMapping("/addTeacher")
	public Teacher saveTeach(@RequestBody Teacher tea) {
		return teach_service.saveTeacher(tea);
	}
	
	@GetMapping("/getTeachers")
	public List<Teacher> findallTeach() {
		return teach_service.getAllTeachers();
	}
	
	@GetMapping("/getTeacher/{id}")
	public Teacher findTeachById(@PathVariable int id) throws ResourceNotFoundException{
		return teach_service.getTeacherById(id);
	}
	
	@PutMapping("/updateTeacher/{id}")
	public Teacher updateTeach(@PathVariable int id,@RequestBody Teacher teach) throws ResourceNotFoundException{
		return teach_service.updateTeacher(id,teach);
	}
	
	@DeleteMapping("/deleteTeacher/{id}")
	public String deleteTeach(@PathVariable int id) {
		return teach_service.deleteTeacher(id);
	}
	
	@GetMapping("/getTeacherByUsername/{user}")
	public Teacher findTeacherByUsername(@PathVariable String user) {
		return teach_service.getTeacherByUsername(user);
	}
	
	
	
}


