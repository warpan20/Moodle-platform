package com.moodle.app.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(
		   generator = ObjectIdGenerators.PropertyGenerator.class,
		   property = "teacher_id",scope=Teacher.class)
@Entity
@Table(name="teacherinfo")
public class Teacher {

	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teacher_id;
	private  String username;
	private  String password;
	private  String email;
	private  String confirm_pass;
	private  String fname;
	private  String lname;
	
	/*@Transient
	 @ManyToMany(mappedBy="teachers")
	    public List<Student> stu=new ArrayList<Student>();*/

	@OneToMany(mappedBy="teacher")
	private List<Course> courses=new ArrayList<Course>();
	
	
	/**
	 * @param username
	 * @param password
	 * @param email
	 * @param confirm_pass
	 * @param fname
	 * @param lname
	 * @param stu
	 * @param courses
	 */
	public Teacher( String username, String password, String email, String confirm_pass,
				String fname, String lname, List<Student> stu, List<Course> courses) {
			super();
			
		this.username = username;
		this.password = password;
		this.email = email;
		this.confirm_pass = confirm_pass;
		this.fname = fname;
		this.lname = lname;
		//this.stu = stu;
		this.courses = courses;
		}
    //Getters and Setters
	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
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

	/*public List<Student> getStu() {
		return stu;
	}

	 
	public void setStu(List<Student> stu) {
		this.stu = stu;
	}*/

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	
	
	
}

