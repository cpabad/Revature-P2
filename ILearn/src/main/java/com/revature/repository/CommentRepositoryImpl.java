package com.revature.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.model.Comment;
import com.revature.model.Lesson;
import com.revature.model.User;
import com.revature.util.HibernateSessionFactory;

@Repository(value = "commentRepository")
public class CommentRepositoryImpl implements CommentRepository {

	@Override
	public Comment findById(int id) {
		Comment c = null;
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			c = s.createQuery("FROM Comment c WHERE c.commentId = :id", Comment.class)
					.setParameter("id", id)
					.getSingleResult();
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return c;
	}

	@Override
	public List<Comment> findByLesson(Lesson lesson) {
		List<Comment> comments = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			comments = s.createQuery("FROM Comment c WHERE c.lesson = :lesson", Comment.class)
					.setParameter("lesson", lesson)
					.getResultList();
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return comments;
	}

	@Override
	public List<Comment> findByCommentAuthorAndLesson(User author, Lesson lesson) {
		List<Comment> comments = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			comments = s.createQuery("FROM Comment c WHERE c.author = :user AND c.lesson = :lesson", Comment.class)
					.setParameter("user", author)
					.setParameter("lesson", lesson)
					.getResultList();
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return comments;
	}

	@Override
	public List<Comment> findByCommentDate(Timestamp date) {
		List<Comment> comments = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			comments = s.createQuery("FROM Comment c WHERE c.comment_date = :date", Comment.class)
					.setParameter("date", date)
					.getResultList();
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return comments;
	}

	@Override
	public List<Comment> findByCommentAuthor(User author) {
		List<Comment> comments = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			comments = s.createQuery("FROM Comment c WHERE c.author = :user", Comment.class)
					.setParameter("user", author)
					.getResultList();
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return comments;
	}

	@Override
	public Comment findByCommentAuthorDateAndLesson(User author, Timestamp date, Lesson lesson) {
		Comment c = null;
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			c = s.createQuery("FROM Comment c WHERE c.author = :user AND c.comment_date = :date AND c.lesson = :lesson", Comment.class)
					.setParameter("user", author)
					.setParameter("date", date)
					.setParameter("lesson", lesson)
					.getSingleResult();
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return c;
	}

	@Override
	public void createComment(Comment comment) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(comment);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
	}

	@Override
	public void updateComment(Comment comment) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.merge(comment);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
	}

	@Override
	public void deleteComment(Comment comment) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.remove(comment);;
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
	}

}
