package com.moodle.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moodle.app.exception.ResourceNotFoundException;
import com.moodle.app.model.Teacher;
import com.moodle.app.repository.TeacherRepo;

@Service
public class TeacherService {

	public TeacherService() {
		// TODO Auto-generated constructor stub
	}
    
	//Dependency Injection
	@Autowired
	private TeacherRepo teachRepo;
	
	public Teacher saveTeacher(Teacher tea) {
		return teachRepo.save(tea);
	}
	
	//Returns List of all Teachers
	public List<Teacher> getAllTeachers() {
		return  teachRepo.findAll();
	}
	
	//Method to get Teacher of particular id
	public Teacher getTeacherById(int id) throws ResourceNotFoundException{
		return teachRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Teacher cannot be found for this id :" + id));
		
	}
	
	//Updates Teacher
	public Teacher updateTeacher(int id,Teacher t) throws ResourceNotFoundException{
		Teacher existing_t = teachRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Teacher cannot be found for this id :" + id));
		
		existing_t.setUsername(t.getUsername());
		existing_t.setFname(t.getFname());	
		existing_t.setLname(t.getLname());
		existing_t.setPassword(t.getPassword());
		existing_t.setConfirm_pass(t.getConfirm_pass());
		existing_t.setEmail(t.getEmail());
		
		return teachRepo.save(existing_t);
	} 
	
	//Deletes teacher of a particular id
	public String deleteTeacher(int id) {
		teachRepo.deleteById(id);
		return "teacher removed" + id;
	}
	//Method to get Teacher by it's username
	public Teacher  getTeacherByUsername(String user) {
		// TODO Auto-generated method stub
		return teachRepo.findTeacherByUsername(user);
	}
	
}


