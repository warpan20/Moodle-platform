package com.moodle.app.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.ObjectMapper;
@JsonIdentityInfo(
		   generator = ObjectIdGenerators.PropertyGenerator.class,
		   property = "student_id", scope=Student.class)

@Entity
@Table(name="studentinfo")
public class Student {

	public Student() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)      
	private int student_id;
	private  String username;
	private  String password;
	private  String email;
	private  String confirm_pass;
	private  String fname;
	private  String lname;
	
	
	@ManyToOne
    private Course courses;
	@OneToOne
    private HomeworkSubmission hs;
	
   /* @ManyToMany
    public List<Teacher> teachers=new ArrayList<Teacher>();*/




	//Constructor
	public Student(String username, String password, String email, String confirm_pass, String fname, String lname,
			Course courses, HomeworkSubmission hs) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.confirm_pass = confirm_pass;
		this.fname = fname;
		this.lname = lname;
		this.courses = courses;
		this.hs = hs;
	}
	
	//Getters and Setters
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getConfirm_pass() {
		return confirm_pass;
	}
	
	public void setConfirm_pass(String confirm_pass) {
		this.confirm_pass = confirm_pass;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public Course getCourses() {
		return courses;
	}
	
	public void setCourses(Course courses) {
		this.courses = courses;
	}
	
	public HomeworkSubmission getHs() {
		return hs;
	}
	
	public void setHs(HomeworkSubmission hs) {
		this.hs = hs;
	}
	
	
		
}	
	
