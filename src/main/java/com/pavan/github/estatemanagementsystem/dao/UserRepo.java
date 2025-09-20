package com.pavan.github.estatemanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pavan.github.estatemanagementsystem.modals.Address;
import com.pavan.github.estatemanagementsystem.modals.User;

@Repository
public class UserRepo {
	
	private final List<User> users = new ArrayList<User>(List.of(
			new User("U001", "Alice Kumar", "alice.k@example.com", "9876543210", "pass@123",
					new Address("A001", "12A", "MG Road", "Bangalore", "India", "560001")),

			new User("U002", "Ravi Mehta", "ravi.m@example.com", "9123456789", "secure@456",
					new Address("A002", "45B", "Park Street", "Kolkata", "India", "700016")),

			new User("U003", "Sneha Reddy", "sneha.r@example.com", "9988776655", "sneha@789",
					new Address("A003", "8C", "Jubilee Hills", "Hyderabad", "India", "500033"))));
	
	public List<User> fetchAllUsers(){
		return users;
	}
	
	public Optional<User> findById(String userID){
		return users.stream().filter(u -> u.getId().equals(userID)).findFirst();
	}
	
	public boolean addUser(User newUser) {
		return users.add(newUser);
	}
}
