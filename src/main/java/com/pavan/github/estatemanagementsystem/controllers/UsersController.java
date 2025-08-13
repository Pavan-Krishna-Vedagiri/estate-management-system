package com.pavan.github.estatemanagementsystem.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.github.estatemanagementsystem.exceptions.NoUserFoundException;
import com.pavan.github.estatemanagementsystem.modals.Address;
import com.pavan.github.estatemanagementsystem.modals.User;
import com.pavan.github.estatemanagementsystem.services.UserManagementService;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	@Autowired
	private UserManagementService userManagementService;
	
	@GetMapping("/")
	public List<User> getAllUsers(){
		return userManagementService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable String id) throws NoUserFoundException {
		return userManagementService.getUserById(id);
	}
	
	@PostMapping("/add")
	public String addUser(@RequestBody User newUser) {
		return userManagementService.addUser(newUser);
	}
	
	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable String id ,@RequestBody User updatedUser) throws NoUserFoundException {
		return userManagementService.updateUser(id, updatedUser);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable String id) throws NoUserFoundException {
		return userManagementService.deleteUser(id);
	}
}
