package com.harshil.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harshil.rest.entities.Course;
import com.harshil.rest.services.CourseService;
@RestController
public class MyController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
    public List<Course> getCourses()
	{
	 return courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return courseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public void deleteCourse(@PathVariable String courseId) {
		courseService.deleteCourse(Long.parseLong(courseId));
	}
	
}
