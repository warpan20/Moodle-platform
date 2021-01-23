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

import com.moodle.app.model.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CaseStudyMoodleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseControllerTest {
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
     public void testGetAllCourses() {
     HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getCourses",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetCourseById() {
    	Course crs = restTemplate.getForObject(getRootUrl() + "/getCourse/1", Course.class);
        System.out.println(crs.getTopics());
        assertNotNull(crs);
    }

    @Test
    public void testCreateCourse() {
    	Course crs = new Course();
    	crs.setTopics("motion");
    	
        ResponseEntity<Course> postResponse = restTemplate.postForEntity(getRootUrl() + "/getCourses", crs,Course.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateCourse() {
        int id = 1;
        Course crs = restTemplate.getForObject(getRootUrl() + "/getCourse/" + id, Course.class);
        crs.setTopics("grammer");
        
        restTemplate.put(getRootUrl() + "/getCourse/" + id, crs);
        Course updatedCourse = restTemplate.getForObject(getRootUrl() + "/UpdateCourse/" + id, Course.class);
        assertNotNull(updatedCourse);
    }

   
}
