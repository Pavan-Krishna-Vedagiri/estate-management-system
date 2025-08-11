package com.pavan.github.estatemanagementsystem.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.github.estatemanagementsystem.exceptions.NoUserFoundException;
import com.pavan.github.estatemanagementsystem.modals.Address;
import com.pavan.github.estatemanagementsystem.modals.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	List<User> users = List.of(
		    new User("U001", "Alice Kumar", "alice.k@example.com", "9876543210",
		        "pass@123",
		        new Address("A001", "12A", "MG Road", "Bangalore", "India", "560001")),

		    new User("U002", "Ravi Mehta", "ravi.m@example.com", "9123456789",
		        "secure@456",
		        new Address("A002", "45B", "Park Street", "Kolkata", "India", "700016")),

		    new User("U003", "Sneha Reddy", "sneha.r@example.com", "9988776655",
		        "sneha@789",
		        new Address("A003", "8C", "Jubilee Hills", "Hyderabad", "India", "500033"))
		);

	
	@GetMapping("/")
	public List<User> getAllUsers(){
		return users;
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable String id) throws NoUserFoundException {
		return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElseThrow(() -> new NoUserFoundException("No user found with given id : " + id));
	}

	
}
