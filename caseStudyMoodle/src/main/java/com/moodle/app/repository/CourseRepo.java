package com.moodle.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moodle.app.model.Course;
import com.moodle.app.model.Student;

public interface CourseRepo extends JpaRepository<Course,Integer> {
	Course findCourseByCname(String crs);
}
