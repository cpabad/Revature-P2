package com.revature;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.revature.model.Course;
import com.revature.model.Lesson;
import com.revature.model.User;
import com.revature.repository.LessonRepository;
import com.revature.repository.LessonRepositoryImpl;
import com.revature.service.CourseService;
import com.revature.service.UserService;
import com.revature.util.HibernateSessionFactory;

@Component(value = "driver")
public class Driver {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CourseService courseService;
	
	public static void main(String[] args) {
		
		
		
		//Testing if we successfully map our models to the tables in the database. 
		//HibernateSessionFactory.getSession();
		
//		LessonRepository lessonRepo = new LessonRepositoryImpl();
//		List<Lesson> lessons = new ArrayList<>();
//		
//		lessons = lessonRepo.getLessonByTitle("Create a new folder");
//		System.out.println(lessons);
		
		
		/*Test UserService and CourseService*/
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Driver driver = ctx.getBean("driver", Driver.class);
		
		/*add new*/
//		Set<Course> enrolledCourse = new HashSet<>();
//		User newUser =  new User("ken@gmail.com","password","ken","huang",enrolledCourse);
//		Course newCourse = new Course("New Course", newUser, "This is new course",true,"",new Date(100000),0);
//		driver.userService.addUser(newUser);
//		driver.courseService.addCourse(newCourse);
		
		/*get one*/
		User user = driver.userService.getUserById(12);
		Course course = driver.courseService.getCourseById(5);
		Course course1 = driver.courseService.getCourseById(1);
		System.out.println("Get a UserById " + user);
		System.out.println("Get a courseById " + course); 
		
		/*update*/
//		user.setFirst_name("Kenny");
//		user.getEnrolled_courses().add(course1);
//		course.setTitle("Update Course");
//		driver.userService.updateUser(user);
//		driver.courseService.updateCourse(course);
//		System.out.println("Updated User: " + driver.userService.getUserById(12));
//		System.out.println("Updated Course " + driver.courseService.getCourseById(5));
		
		/*Delete one*/
		/*Be careful here, Delete a user, the course created by that user will automatically get deleted too */
		//driver.userService.deleteUser(user);
		//driver.courseService.deleteCourse(course);
		
		
		/*Get All*/
		System.out.println("Get all users " + driver.userService.getAllUsers());
		System.out.println("Get all users " + driver.courseService.getAllCourses());
		
<<<<<<< HEAD
		lessons = lessonRepo.getLessonByCourseId(2);
		System.out.println(lessons);
=======
>>>>>>> e1210cc01f337f0e3ba7475c2c753b2cf8a6d055
	}

}
