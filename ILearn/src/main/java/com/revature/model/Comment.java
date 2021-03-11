package com.revature.model;

import java.sql.Timestamp;

import javax.persistence.*;


/**
 * 
 * @author kenny Huang
 *
 */
@Entity
@Table (name = "user_comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int commentId;
	
	@JoinColumn(name = "lessonId")
	@ManyToOne
	private Lesson lesson;
	
	@JoinColumn(name = "authorId")
	@ManyToOne
	private User author;
	
	@Column (name = "lesson_comment")
	private String comment;
	
	@Column
	private Timestamp comment_date;
	
	@Column
	private int like_counter;
	
	@Column
	private int dislike_counter;

	public Comment() {
		super();
	}
	
	

	public Comment(int commentId, Lesson lesson, User author, String comment, Timestamp comment_date, int like_counter,
			int dislike_counter) {
		super();
		this.commentId = commentId;
		this.lesson = lesson;
		this.author = author;
		this.comment = comment;
		this.comment_date = comment_date;
		this.like_counter = like_counter;
		this.dislike_counter = dislike_counter;
	}


	//Override the constructor without commentId parameter since we use serial type in our table
	public Comment(Lesson lesson, User author, String comment, Timestamp comment_date, int like_counter,
			int dislike_counter) {
		super();
		this.lesson = lesson;
		this.author = author;
		this.comment = comment;
		this.comment_date = comment_date;
		this.like_counter = like_counter;
		this.dislike_counter = dislike_counter;
	}



	public int getCommentId() {
		return commentId;
	}



	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}



	public Lesson getLesson() {
		return lesson;
	}



	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}



	public User getAuthor() {
		return author;
	}



	public void setAuthor(User author) {
		this.author = author;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public Timestamp getComment_date() {
		return comment_date;
	}



	public void setComment_date(Timestamp comment_date) {
		this.comment_date = comment_date;
	}



	public int getLike_counter() {
		return like_counter;
	}



	public void setLike_counter(int like_counter) {
		this.like_counter = like_counter;
	}



	public int getDislike_counter() {
		return dislike_counter;
	}



	public void setDislike_counter(int dislike_counter) {
		this.dislike_counter = dislike_counter;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + commentId;
		result = prime * result + ((comment_date == null) ? 0 : comment_date.hashCode());
		result = prime * result + dislike_counter;
		result = prime * result + ((lesson == null) ? 0 : lesson.hashCode());
		result = prime * result + like_counter;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (commentId != other.commentId)
			return false;
		if (comment_date == null) {
			if (other.comment_date != null)
				return false;
		} else if (!comment_date.equals(other.comment_date))
			return false;
		if (dislike_counter != other.dislike_counter)
			return false;
		if (lesson == null) {
			if (other.lesson != null)
				return false;
		} else if (!lesson.equals(other.lesson))
			return false;
		if (like_counter != other.like_counter)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", lesson=" + lesson + ", author=" + author + ", comment=" + comment
				+ ", comment_date=" + comment_date + ", like_counter=" + like_counter + ", dislike_counter="
				+ dislike_counter + "]";
	}
	
	
	
	
	
	
}
