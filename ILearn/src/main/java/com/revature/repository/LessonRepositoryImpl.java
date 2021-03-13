package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.model.Course;
import com.revature.model.Lesson;
import com.revature.util.HibernateSessionFactory;

/**
 * 
 * @author Jason Arias
 *
 */


@Repository(value = "lessonRepository")
public class LessonRepositoryImpl implements LessonRepository {

	public LessonRepositoryImpl() {
		
	}
	
	@Override
	public void createLesson(Lesson lesson) {
		Session s = null;
		Transaction tx =null;
		
		try {
			
			s=HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(lesson);
			tx.commit();
			
		}catch(HibernateException e) {
			
			e.printStackTrace();
			tx.rollback();
			
		}finally {
			s.close();
		}
		
	}

	/*
	 * Error: org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: 
	 *  com.revature.model.User.enrolled_courses, could not initialize proxy - no Session
	 */
	@Override
	public List<Lesson> getLessonByCourseId(int courseid) {
		List<Lesson> lessons = new ArrayList<>();
		Session s = null;
		Transaction tx =null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
<<<<<<< HEAD
			lessons = s.createQuery("FROM Lesson l WHERE l.course.courseId = :courseid",Lesson.class)
=======
			lessons = s.createQuery("FROM Lesson WHERE courseid = :courseid",Lesson.class)
>>>>>>> 2b0e8f3d7fa411c094a8743e5b8b587f79a9c09f
					.setParameter("courseid", courseid)
					.getResultList();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return lessons;
	}

	/*
	 * Error: org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: 
	 *  com.revature.model.User.enrolled_courses, could not initialize proxy - no Session
	 */
	@Override
	public List<Lesson> getLessonByLessonId(int lessonid) {
		List<Lesson> lessons = new ArrayList<>();
		Session s = null;
		Transaction tx =null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			lessons = s.createQuery("FROM Lesson WHERE lessonid = :lessonid",Lesson.class)
					.setParameter("lessonid", lessonid)
					.getResultList();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return lessons;
	}

	/*
	 * Error: org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: 
	 *  com.revature.model.User.enrolled_courses, could not initialize proxy - no Session
	 */
	@Override
	public List<Lesson> getLessonByTitle(String title) {
		Session s = null;
		Transaction tx = null;
		List<Lesson> lessons = new ArrayList<>();
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			lessons = s.createQuery("FROM Lesson l WHERE l.title = :title",Lesson.class)
					.setParameter("title", title)
					.getResultList();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		
		
		return lessons;
	}

	@Override
	public void updateLesson(Lesson lesson) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.update(lesson);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			s.close();
		}
		
	}

	@Override
	public void deleteLesson(Lesson lesson) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.delete(lesson);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			s.close();
		}
	}

}
