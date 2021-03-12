package com.revature.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.model.Comment;
import com.revature.model.Course;
import com.revature.model.Lesson;
import com.revature.model.User;
import com.revature.repository.CommentRepositoryImpl;

public class CommentRepositoryTest {
	
	private static CommentRepositoryImpl commentRepository;
	
	@BeforeClass
	public static void setupBeforeClass() {
		commentRepository = new CommentRepositoryImpl();
	}
	
	@Test
	public void testFindById() {
		Comment retrievedComment = commentRepository.findById(1);
		Assert.assertEquals(1, retrievedComment.getCommentId());
	}
	
	@Test
	public void testFindByLesson() {
		Set<Course> repoCourses = new HashSet<>();
		User repoUser = new User(1, "a@email.com", "userpass", "John", "Smith", repoCourses);
		Course repoCourse = new Course(1, "Basic Computer Skills", repoUser, "Learning how to create folders, cut and paste, copy and paste, and undo", true, "", Date.valueOf("2000-01-01"), 4);
		Lesson repoLesson = new Lesson(1, "Create a new folder", repoCourse, "howtocreatefolder.mp4");
		List<Comment> retrievedComments = commentRepository.findByLesson(repoLesson);
		Assert.assertEquals(1, retrievedComments.get(0).getAuthor().getUserId());
	}
	
	@Test
	public void testFindByCommentAuthorAndLesson() {
		Set<Course> repoCourses = new HashSet<>();
		User repoUser = new User(1, "a@email.com", "userpass", "John", "Smith", repoCourses);
		Course repoCourse = new Course(1, "Basic Computer Skills", repoUser, "Learning how to create folders, cut and paste, copy and paste, and undo", true, "", Date.valueOf("2000-01-01"), 4);
		Lesson repoLesson = new Lesson(1, "Create a new folder", repoCourse, "howtocreatefolder.mp4");
		List<Comment> retrievedComments = commentRepository.findByCommentAuthorAndLesson(repoUser, repoLesson);
		Assert.assertEquals(1, retrievedComments.get(0).getAuthor().getUserId());
	}
	
	@Test
	public void testFindByCommentDate() {
		List<Comment> retrievedComments = commentRepository.findByCommentDate(Timestamp.valueOf("2021-03-11 18:00:00"));
		Assert.assertEquals(1, retrievedComments.get(0).getAuthor().getUserId());
	}
	
	@Test
	public void testFindByCommentAuthorDateAndLesson() {
		Set<Course> repoCourses = new HashSet<>();
		User repoUser = new User(1, "a@email.com", "userpass", "John", "Smith", repoCourses);
		Course repoCourse = new Course(1, "Basic Computer Skills", repoUser, "Learning how to create folders, cut and paste, copy and paste, and undo", true, "", Date.valueOf("2000-01-01"), 4);
		Lesson repoLesson = new Lesson(1, "Create a new folder", repoCourse, "howtocreatefolder.mp4");
		Comment retrievedComment = commentRepository.findByCommentAuthorDateAndLesson(repoUser, Timestamp.valueOf("2021-03-11 18:00:00"), repoLesson);
		Assert.assertEquals(1, retrievedComment.getCommentId());
	}
	
	@Test
	public void testCreateUpdateDeleteComment1() {
		Set<Course> repoCourses = new HashSet<>();
		User repoUser = new User(1, "a@email.com", "userpass", "John", "Smith", repoCourses);
		Course repoCourse = new Course(1, "Basic Computer Skills", repoUser, "Learning how to create folders, cut and paste, copy and paste, and undo", true, "", Date.valueOf("2000-01-01"), 4);
		Lesson repoLesson = new Lesson(1, "Create a new folder", repoCourse, "howtocreatefolder.mp4");
		Comment newComment = new Comment(100, repoLesson, repoUser, "lol wuttttt", Timestamp.valueOf("2021-03-11 17:00:00"), 0, 0);
		commentRepository.createComment(newComment);
	}
	
	@Test
	public void testCreateUpdateDeleteComment2() {
		Set<Course> repoCourses = new HashSet<>();
		User repoUser = new User(1, "a@email.com", "userpass", "John", "Smith", repoCourses);
		Course repoCourse = new Course(1, "Basic Computer Skills", repoUser, "Learning how to create folders, cut and paste, copy and paste, and undo", true, "", Date.valueOf("2000-01-01"), 4);
		Lesson repoLesson = new Lesson(1, "Create a new folder", repoCourse, "howtocreatefolder.mp4");
		Comment retrievedComment = commentRepository.findByCommentAuthorDateAndLesson(repoUser, Timestamp.valueOf("2021-03-11 17:00:00"), repoLesson);
		retrievedComment.setLike_counter(1);
		commentRepository.updateComment(retrievedComment);
		Assert.assertEquals(1, commentRepository.findByCommentAuthorDateAndLesson(repoUser, Timestamp.valueOf("2021-03-11 17:00:00"), repoLesson).getLike_counter());
	}
	
	@Test
	public void testCreateUpdateDeleteComment3() {
		Set<Course> repoCourses = new HashSet<>();
		User repoUser = new User(1, "a@email.com", "userpass", "John", "Smith", repoCourses);
		Course repoCourse = new Course(1, "Basic Computer Skills", repoUser, "Learning how to create folders, cut and paste, copy and paste, and undo", true, "", Date.valueOf("2000-01-01"), 4);
		Lesson repoLesson = new Lesson(1, "Create a new folder", repoCourse, "howtocreatefolder.mp4");
		Comment retrievedComment = commentRepository.findByCommentAuthorDateAndLesson(repoUser, Timestamp.valueOf("2021-03-11 17:00:00"), repoLesson);
		commentRepository.deleteComment(retrievedComment);
	}
	
	

}
