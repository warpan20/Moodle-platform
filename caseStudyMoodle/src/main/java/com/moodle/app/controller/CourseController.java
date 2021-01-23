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
import com.moodle.app.model.Course;
import com.moodle.app.service.CourseService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class CourseController {
        
	   //Dependency Injection
		@Autowired
		private CourseService course_service;
		
		
		@PostMapping("/addCourse")
		public Course saveCrs(@RequestBody Course crs) {
			return course_service.saveCourse(crs);
		}
		
		@GetMapping("/getCourses")
		public List<Course> findallCourses() {
			return course_service.getAllCourses();
		}
		
		@GetMapping("/getCourse/{cid}")
		public Course findCrsById(@PathVariable int cid) throws ResourceNotFoundException{
			return course_service.getCourseById(cid);
		}
		
		@PutMapping("/updateCourse/{cid}")
		public Course updateCrs(@PathVariable int cid,@RequestBody Course c) throws ResourceNotFoundException{
			return course_service.updateCourse(cid,c);
		}
		
		@DeleteMapping("/deleteCourse/{cid}")
		public String deleteCrs(@PathVariable int cid) {
			return course_service.deleteCourse(cid);
		}
		@GetMapping("/getCourseByCname/{cname}")
		public Course findCourseByUsername(@PathVariable String cname) {
			return course_service.getCourseByCname(cname);
		}
		
		
	}

