package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User getUserById(int id) {

		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User updateUser(User user, int id) {
		Optional<User> userUpdate = userRepository.findById(id);
		if (userUpdate.isPresent()) {
			User existingUser = userUpdate.get();
			existingUser.setUserName(user.getUserName());
			existingUser.setEmailId(user.getEmailId());
			existingUser.setMblNumber(user.getMblNumber());
			return userRepository.save(existingUser);
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(int id) {

		userRepository.deleteById(id);
	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

}
