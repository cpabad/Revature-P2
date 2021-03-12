package com.revature.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.model.Lesson;
import com.revature.repository.LessonRepositoryImpl;

public class LessonRepositoryTest {
	
	private static LessonRepositoryImpl lessonRepository;
	
	@BeforeClass
	public static void setupBeforeClass() {
		lessonRepository = new LessonRepositoryImpl();
	}
	
	@Test
	public void testGetLessonByCourseId() {
		List<Lesson> retrievedLessons = lessonRepository.getLessonByCourseId(1);
		Assert.assertEquals(1, retrievedLessons.get(0).getLessonId());
	}
	
	@Test
	public void testGetLessonByLessonId() {
		List<Lesson> retrievedLessons = lessonRepository.getLessonByLessonId(1);
		Assert.assertEquals(1, retrievedLessons.get(0).getLessonId());
	}
	
	@Test
	public void testGetLessonByTitle() {
		List<Lesson> retrievedLessons = lessonRepository.getLessonByTitle("Create a new folder");
		Assert.assertEquals(1, retrievedLessons.get(0).getLessonId());
	}

}
