package com.moodle.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moodle.app.model.HomeworkSubmission;


@Repository
public interface HwSubRepo extends JpaRepository<HomeworkSubmission,Integer>{
	
}
