package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping("users")
	public List<User> getAllUser() {
		return service.getAllUsers();

	}

	@PostMapping("users")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}

	@GetMapping("users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User userBy = service.getUserById(id);
		if (userBy != null) {
			return new ResponseEntity<>(userBy, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("updateUsers/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
		User userUpdated = service.updateUser(user,id);
		if (userUpdated != null) {
			return new ResponseEntity<>(userUpdated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("users/{id}")
	public String deleteById(@PathVariable int id) {
		service.deleteById(id);
		return "User with ID " + id + " deleted successfully";
	}

}
