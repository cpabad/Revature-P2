package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.model.Course;
import com.revature.util.HibernateSessionFactory;


/**
 * This is the class that implements CourseRepository interface 
 * This class will override all the methods that defined in the interface 
 * and define our actual method implementation. 
 * @author kenny Huang
 *
 */
@Repository(value = "courseRepository")
public class CourseRepositoryImpl implements CourseRepository{

	@Override
	public void addCourse(Course course) {
		
		//All of the work is done with the context of a Hibernate session
		Session s = null;
		
		/*
		 * The Transaction interface allows us control over our DB transactions.
		 * we can use it to rollback changes, commit changes, and begin transactions. 
		 */
		Transaction tx = null;
		
		//Handle HibernateException by using try catch block
		try {
			s = HibernateSessionFactory.getSession(); //Get a Hibernate Session
			tx = s.beginTransaction(); //Call this method to start our transaction
			s.save(course); //This method creates a new course record in the Course table
			tx.commit(); //Commit our transaction
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();  //When Exception occurs, rollback transaction
		}finally{
			s.close(); // close Hibernate session
		}
		
	}

	@Override
	public void updateCourse(Course course) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.update(course);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			s.close();
		}
		
	}

	@Override
	public void deleteCourse(Course course) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.delete(course);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			s.close();
		}
		
	}

	@Override
	public Course getCourseById(int id) {
		Course course = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			course = s.get(Course.class, id);
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			s.close();
		}
				
		return course;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			courses = s.createQuery("from Course").getResultList();
			tx.commit();
		}catch(HibernateException e) {
		 e.printStackTrace();
		 tx.rollback();
		}finally {
			s.close();
		}
		return courses;
	}

	
}
