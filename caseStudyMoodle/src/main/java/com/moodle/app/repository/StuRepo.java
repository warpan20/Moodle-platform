package com.moodle.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moodle.app.model.Student;


@Repository
public interface StuRepo extends JpaRepository<Student,Integer>{
	Student findStudByUsername(String user);
}
