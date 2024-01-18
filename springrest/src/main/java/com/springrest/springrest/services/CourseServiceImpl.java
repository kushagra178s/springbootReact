package com.springrest.springrest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
//	List<Course> list;
	
	public CourseServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Course(145, "Java Core  Course", "this course contains basic java"));
//		list.add(new Course(146, "Spring Boot Course", "this course contains Spring Boot"));
	}
	
	@Override
	public List<Course> getCourses() {
//		return list;
		return courseDao.findAll();
	}
	
	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
////		c e t y p 
//		for(Course course: list) {
//			if(course.getId()==courseId) {
//				c = course;
//				break;
//			}
//		}
		return this.courseDao.findById(courseId).orElse(null);
	}

	
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
//		list.add(course);	
//		return course;
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if(e.getId()==course.getId()) {
//				e.setDescription(course.getDescription());
//				e.setTitle(course.getTitle());
//			}
//		});
//		return course;
		courseDao.save(course);
		return course;
	}

//	@Override
//	public void deleteCourse(long courseId) {
//		System.out.println("hello");
//		list = this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
//		return list;
//	}
	@Override
	public void deleteCourse(long courseId) {
		Course entity =  courseDao.getById(courseId);
		courseDao.delete(entity);
	}
}
