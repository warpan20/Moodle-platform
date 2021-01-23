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

import com.moodle.app.model.Teacher;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CaseStudyMoodleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeacherControllerTest {
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
     public void testGetAllTeachers() {
     HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getTeacher",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetTeacherById() {
    	Teacher teach = restTemplate.getForObject(getRootUrl() + "/getTeacher/1", Teacher.class);
        System.out.println(teach.getFname());
        assertNotNull(teach);
    }

    @Test
    public void testCreateTeacher() {
    	Teacher teach = new Teacher();
    	teach.setEmail("mini@gmail.com");
    	teach.setFname("mini");
    	teach.setLname("mini");
        ResponseEntity<Teacher> postResponse = restTemplate.postForEntity(getRootUrl() + "/getTeachers", teach, Teacher.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateTeacher() {
        int id = 1;
        Teacher teach = restTemplate.getForObject(getRootUrl() + "/getTeacher/" + id, Teacher.class);
        teach.setFname("mini");
        teach.setLname("mini");
        restTemplate.put(getRootUrl() + "/getTeacher/" + id, teach);
        Teacher updatedTeacher = restTemplate.getForObject(getRootUrl() + "/UpdateTeacher/" + id, Teacher.class);
        assertNotNull(updatedTeacher);
    }

   
}