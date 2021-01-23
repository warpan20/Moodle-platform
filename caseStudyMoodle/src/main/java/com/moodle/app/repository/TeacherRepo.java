package com.moodle.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.moodle.app.model.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Integer>{ 
	Teacher  findTeacherByUsername(String user);
}
