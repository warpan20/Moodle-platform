package com.moodle.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moodle.app.exception.ResourceNotFoundException;
import com.moodle.app.model.Course;
import com.moodle.app.repository.CourseRepo;

/**
 * @author archita
 *
 */
@Service
public class CourseService {

	    //Dependency Injection
		@Autowired
		private CourseRepo csRepo;
		
		public Course saveCourse(Course crs) {
			return csRepo.save(crs);
		}
		
		//Returns List of all courses
		public List<Course> getAllCourses() {
			return  csRepo.findAll();
		}
		
		//Method to get course of a particular id
		public Course getCourseById(int id) throws ResourceNotFoundException{
			return csRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Course cannot be found for this id :" + id));
			
		}
		
		//Updates course
		public Course updateCourse(int cid,Course crs) throws ResourceNotFoundException{
			Course existing_course = csRepo.findById(cid).orElseThrow(()-> new ResourceNotFoundException("Course cannot be found for this id :" + cid));
			
			existing_course.setCname(crs.getCname());
			existing_course.setTopics(crs.getTopics());
			existing_course.setStu(crs.getStu());
			existing_course.setTeacher(crs.getTeacher());
			return csRepo.save(existing_course);
		} 
		
		//Deletes course of a particular id
		public String deleteCourse(int cid) {
			csRepo.deleteById(cid);
			return "course removed" + cid;
		}
		
		//Method to get course by username
		public Course getCourseByCname(String crs) {
			// TODO Auto-generated method stub
			return csRepo.findCourseByCname(crs);
		}
		
	}

