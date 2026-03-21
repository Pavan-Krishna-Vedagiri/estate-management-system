package com.pavan.github.estatemanagementsystem.controllers;

import java.util.List;

import com.pavan.github.estatemanagementsystem.constants.UrlConstants;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.github.estatemanagementsystem.exceptions.NoUserFoundException;
import com.pavan.github.estatemanagementsystem.entities.User;
import com.pavan.github.estatemanagementsystem.services.UserService;

@RestController
@RequestMapping(UrlConstants.USERS)
public class UsersController {

	private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") String userId) throws NoUserFoundException {
		return userService.getUserById(userId);
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping
	public String addUser(@RequestBody User newUser) {
		return userService.addUser(newUser);
	}
	
	@PutMapping("/{id}")
	public String updateUser(@PathVariable String id ,@RequestBody User updatedUser) throws NoUserFoundException {
		return userService.updateUser(id, updatedUser);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") String userId) throws NoUserFoundException {
		return userService.deleteUser(userId);
	}
}
