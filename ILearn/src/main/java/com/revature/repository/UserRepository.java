package com.revature.repository;

import java.util.List;

import com.revature.model.User;


/**
 * This interface consists methods that we will need to implement in the class 
 * that wants to access the database to retrieve,add,update,delete users.  
 * @author Kenny Huang
 *
 */
public interface UserRepository {
	
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	User getUserById(int id);
	List<User> getAllUsers();

}
