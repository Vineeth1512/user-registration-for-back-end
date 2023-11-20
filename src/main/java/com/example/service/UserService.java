package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface UserService {
	
	User addUser(User user);

	User getUserById(int id);

	User updateUser(User user, int id);

	void deleteById(int id);

	List<User> getAllUsers();

}
