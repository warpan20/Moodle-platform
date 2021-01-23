package com.moodle.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		   generator = ObjectIdGenerators.PropertyGenerator.class,
		   property = "sid",scope=HomeworkSubmission.class)
@Entity
@Table(name="homeworksubmission")
public class HomeworkSubmission {

	public HomeworkSubmission() {
		// TODO Auto-generated constructor stub
	}
	
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sid;
	private String ans;
	private String grade;
	
	/**
	 * @param ans
	 * @param grade
	 */
	public HomeworkSubmission(String ans, String grade) {
		super();
		this.ans = ans;
		this.grade = grade;
	}
	
	//Getters and setters
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	
}
