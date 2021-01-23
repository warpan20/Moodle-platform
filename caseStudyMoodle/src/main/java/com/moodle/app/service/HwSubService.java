package com.moodle.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moodle.app.model.HomeworkSubmission;
import com.moodle.app.repository.HwSubRepo;
import com.moodle.app.exception.*;
@Service
public class HwSubService {
    
	//Dependency Injection
	@Autowired
	private HwSubRepo hwRepo;
	
	public HomeworkSubmission saveSubmission(HomeworkSubmission hsub) {
		return hwRepo.save(hsub);
	}
	
	//Returns  List of all Homework SDubmissions
	public List<HomeworkSubmission> getAllSubmissions() {
		return  hwRepo.findAll();
	}
	
	//Method to get submission of a particular id
	public HomeworkSubmission getSubmissionById(int id) 
		throws ResourceNotFoundException{
		return hwRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Submission not found for this id :" + id));
	}
	
	//Updates submission
	public HomeworkSubmission updateSubmission(int id,HomeworkSubmission hsub) throws ResourceNotFoundException{
		HomeworkSubmission existing_sub = hwRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Submission cannot be found for this id :" + id));
		
		existing_sub.setAns(hsub.getAns());
		existing_sub.setGrade(hsub.getGrade());	
		
		return hwRepo.save(existing_sub);
	} 
	
	//Deletes Submission of a particular id
	public String deleteSubmission(int id) {
		hwRepo.deleteById(id);
		return "submission removed" + id;
	}
	
		
	 
}

