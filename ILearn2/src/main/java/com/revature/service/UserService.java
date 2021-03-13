package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserRepository;



/**
 * This is the service layer class for User that we will use to provide logic operate on 
 * the data sent to and from the repository and the client.
 * @author kenny Huang
 *
 */
@Service(value = "userService")
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user) {
		
		this.userRepository.save(user);
	}
	
	public void updateUser(User user) {
		
		this.userRepository.save(user);
		
	}
	
	public void deleteUser(User user) {
		
		this.userRepository.delete(user);
		
	}
	
	public User getUserById(Integer id) {
		
		return this.userRepository.findByUserid(id);
	}
	
	public List<User> getAllUsers(){
		
		return this.userRepository.findAll();
		
	}

}
