package com.moodle.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.moodle.app.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CaseStudyMoodleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StuControllerTest {
    @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }

     @Test
     public void contextLoads() {

     }

     @Test
     public void testGetAllStudents() {
     HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getStudents",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetStudentById() {
    	Student stu = restTemplate.getForObject(getRootUrl() + "/getStudent/1", Student.class);
        System.out.println(stu.getFname());
        assertNotNull(stu);
    }

    @Test
    public void testCreateStudent() {
    	Student stu = new Student();
    	stu.setEmail("mini@gmail.com");
    	stu.setFname("mini");
    	stu.setLname("mini");
        ResponseEntity<Student> postResponse = restTemplate.postForEntity(getRootUrl() + "/getStudents", stu, Student.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateStudent() {
        int id = 1;
        Student stu = restTemplate.getForObject(getRootUrl() + "/getStudent/" + id, Student.class);
        stu.setFname("mini");
        stu.setLname("mini");
        restTemplate.put(getRootUrl() + "/getStudent/" + id, stu);
        Student updatedStudent = restTemplate.getForObject(getRootUrl() + "/UpdateStudent/" + id, Student.class);
        assertNotNull(updatedStudent);
    }

   
}