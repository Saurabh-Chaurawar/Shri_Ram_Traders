package com.shriram.service;

import java.util.List;

import com.shriram.entities.User;
import com.shriram.exception.UserException;

public interface UserService {
	
	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;
	
	public List<User> findAllUsers();

}
