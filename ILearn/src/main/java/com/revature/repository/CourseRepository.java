package com.revature.repository;

import java.util.List;

import com.revature.model.Course;
import com.revature.model.User;

/**
 * This interface consists methods that we will need to implement in the class 
 * that wants to access the database to retrieve,add,update,delete courses.  
 * @author kenny
 *
 */
public interface CourseRepository {
	
	void addCourse(Course course);
	void updateCourse(Course course);
	void deleteCourse(Course course);
	Course getCourseById(int id);
	List<Course> getAllCourses();

}
