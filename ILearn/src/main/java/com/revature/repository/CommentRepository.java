package com.revature.repository;

import java.sql.Timestamp;
import java.util.List;

import com.revature.model.Comment;
import com.revature.model.Lesson;
import com.revature.model.User;

public interface CommentRepository {
	
	Comment findById(int id);
	List<Comment> findByLesson(Lesson lesson);
	List<Comment> findByCommentAuthorAndLesson(User author, Lesson lesson);
	List<Comment> findByCommentDate(Timestamp date);
	List<Comment> findByCommentAuthor(User author);
	Comment findByCommentAuthorDateAndLesson(User author, Timestamp date, Lesson lesson);
	void createComment(Comment comment);
	void updateComment(Comment comment);
	void deleteComment(Comment comment);

}
