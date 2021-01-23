package com.moodle.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moodle.app.model.Student;
import com.moodle.app.repository.StuRepo;
import com.moodle.app.exception.*;
@Service
public class StuService {

	//Dependency Injection
	@Autowired
	private StuRepo stuRepo;
	
	public Student saveStudent(Student stud) {
		return stuRepo.save(stud);
	}
	
	//Returns List of all students
	public List<Student> getAllStudents() {
		return  stuRepo.findAll();
	}
	
	//Method to get student of particular id
	public Student getStudentById(int id) 
		throws ResourceNotFoundException{
		return stuRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student not found for this id :" + id));
	}
	
	//Updates student of particular id
	public Student updateStudent(int id,Student stud) throws ResourceNotFoundException{
		Student existing_student = stuRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student cannot be found for this id :" + id));
		
		existing_student.setUsername(stud.getUsername());
		existing_student.setEmail(stud.getEmail());	
		existing_student.setPassword(stud.getPassword());
		existing_student.setConfirm_pass(stud.getConfirm_pass());
		existing_student.setFname(stud.getFname());
		existing_student.setLname(stud.getLname());
		existing_student.setCourses(stud.getCourses());
		return stuRepo.save(existing_student);
	} 
	//Delete student of particular id
	public String deleteStudent(int id) {
		stuRepo.deleteById(id);
		return "student removed" + id;
	}
	
	//Method to get student by it's username
	public Student getStudentByUsername(String user) {
		// TODO Auto-generated method stub
		return stuRepo.findStudByUsername(user);
	}
	
		
	 
}

