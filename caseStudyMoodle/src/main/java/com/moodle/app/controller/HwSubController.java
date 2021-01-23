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
import com.moodle.app.model.HomeworkSubmission;
import com.moodle.app.service.HwSubService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class HwSubController {
         
	   //Dependency Injection
		@Autowired
		private HwSubService hw_service;
		
		
		@PostMapping("/addSubmission")
		public HomeworkSubmission saveSub(@RequestBody HomeworkSubmission sub) {
			return hw_service.saveSubmission(sub);
		}
		
		@GetMapping("/getSubmissions")
		public List<HomeworkSubmission> findallSubmissions() {
			return hw_service.getAllSubmissions();
		}
		
		@GetMapping("/getSubmission/{sid}")
		public HomeworkSubmission findSubById(@PathVariable int sid) throws ResourceNotFoundException{
			return hw_service.getSubmissionById(sid);
		}
		
		@PutMapping("/updateSubmission/{sid}")
		public HomeworkSubmission updateSub(@PathVariable int sid,@RequestBody HomeworkSubmission h) throws ResourceNotFoundException{
			return hw_service.updateSubmission(sid,h);
		}
		
		@DeleteMapping("/deleteSubmission/{sid}")
		public String deleteSub(@PathVariable int sid) {
			return hw_service.deleteSubmission(sid);
		}
		
		
		
	}

