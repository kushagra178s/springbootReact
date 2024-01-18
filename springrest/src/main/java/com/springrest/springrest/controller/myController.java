package com.springrest.springrest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class myController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home") 
	public String home() {
		return "this is home page";
	}
	//get the list of courses
	@GetMapping("/courses")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Course> getCourses() {
		return this.courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	@CrossOrigin(origins = "http://localhost:3000")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	@CrossOrigin(origins = "http://localhost:3000")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
//	@DeleteMapping("/courses/{courseId}")
//	public String deleteCourse(@RequestBody String courseId) 
//	{
////		this.courseService.deleteCourse(Long.parseLong(courseId));
//		return "done";
//		
//	}
	@DeleteMapping("/courses/{courseId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public void deleteCourse(@PathVariable String courseId) {
		this.courseService.deleteCourse(Long.parseLong(courseId));
//		return courseId;
	}
} 