package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.revature.model.User;
import com.revature.util.HibernateSessionFactory;


/**
 * This is the class that implements UserRepository interface 
 * This class will override all the methods that defined in the interface 
 * and define our actual method implementation. 
 * @author kenny Huang
 *
 */

@Repository(value = "UserRepository")
public class UserRepositoryImpl implements UserRepository{

	@Override
	public void addUser(User user) {
		
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
			s.save(user); //This method creates a new user record in the User table
			tx.commit();  //Commit our transaction
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();//When Exception occurs, rollback transaction
		}finally{
			s.close();// close Hibernate session
		}
		
		
	}

	@Override
	public void updateUser(User user) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.update(user);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			s.close();
		}
		
	}

	@Override
	public void deleteUser(User user) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.delete(user);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			s.close();
		}
		
	}

	@Override
	public User getUserById(int id) {
		
		User user = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			user = s.get(User.class, id);
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			s.close();
		}
				
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			users = s.createQuery("from User").getResultList();
			tx.commit();
		}catch(HibernateException e) {
		 e.printStackTrace();
		 tx.rollback();
		}finally {
			s.close();
		}
		return users;
	}
	
}
