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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(
		   generator = ObjectIdGenerators.PropertyGenerator.class,
		   property = "cid",scope=Course.class)
@Entity
@Table(name="courseinfo")
public class Course {

	public Course() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	private  String cname;
    
	
	private  String topics;
	
    @OneToMany
    private List<Student> stu=new ArrayList<Student>();
   
    
   
   
    @ManyToOne
    private Teacher teacher;
    
    private String hworkQuestion;
    

	
	
	
    //Constructor
	public Course(String cname, String topics, List<Student> stu, Teacher teacher, String hworkQuestion) {
		super();
		this.cname = cname;
		this.topics = topics;
		this.stu = stu;
		this.teacher = teacher;
		this.hworkQuestion = hworkQuestion;
	}
	
	//Getters and setters
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTopics() {
		return  topics;
	}
	public void setTopics(String list) {
		this.topics = list;
	}
	public List<Student> getStu() {
		return stu;
	}
	public void setStu(List<Student> list) {
		this.stu = list;
	}


	
	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getHworkQuestion() {
		return hworkQuestion;
	}
	public void setHworkQuestion(String hworkQuestion) {
		this.hworkQuestion = hworkQuestion;
	}
	

	

	
    
}


