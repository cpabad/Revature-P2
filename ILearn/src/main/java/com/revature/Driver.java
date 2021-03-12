package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Course;
import com.revature.model.Lesson;
import com.revature.repository.LessonRepository;
import com.revature.repository.LessonRepositoryImpl;
import com.revature.util.HibernateSessionFactory;

public class Driver {
	
	public static void main(String[] args) {
		
		//Testing if we successfully map our models to the tables in the database. 
		HibernateSessionFactory.getSession();
		
		LessonRepository lessonRepo = new LessonRepositoryImpl();
		List<Lesson> lessons = new ArrayList<>();
		
		lessons = lessonRepo.getLessonByCourseId(2);
		System.out.println(lessons);
	}

}
