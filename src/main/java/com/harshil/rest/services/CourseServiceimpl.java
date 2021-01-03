package com.harshil.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.harshil.rest.entities.Course;

@Service
public class CourseServiceimpl implements CourseService {

	List<Course> list;
	
	public CourseServiceimpl() {
	list=new ArrayList<>(); 
	list.add(new Course(145,"Java Core Course","contains basics of java"));
	list.add(new Course(4343,"Spring boot Course","creating rest api"));
	}
	
	
	
	public List<Course> getCourses() {
		
		return list;
	}



	@Override
	public Course getCourse(long courseId) {
		Course c=null;
		
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}



	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}



	@Override
	public Course updateCourse(Course course) {
		list.forEach(e ->{
			if(e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}



	@Override
	public void deleteCourse(long courseId) {
           Course c1=null;
		
		for(Course course:list) {
			if(course.getId()==courseId) {
				c1=course;
				break;
			}
		}
		
		list.remove(c1);
	}
	
	
    
	
	
	
}
