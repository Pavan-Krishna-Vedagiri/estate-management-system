package com.pavan.github.estatemanagementsystem.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.github.estatemanagementsystem.dao.UserRepo;
import com.pavan.github.estatemanagementsystem.exceptions.NoUserFoundException;
import com.pavan.github.estatemanagementsystem.modals.Address;
import com.pavan.github.estatemanagementsystem.modals.User;

@Service
public class UserManagementService {

	public List<User> users = new ArrayList<User>(List.of(
			new User("U001", "Alice Kumar", "alice.k@example.com", "9876543210", "pass@123",
					new Address("A001", "12A", "MG Road", "Bangalore", "India", "560001")),

			new User("U002", "Ravi Mehta", "ravi.m@example.com", "9123456789", "secure@456",
					new Address("A002", "45B", "Park Street", "Kolkata", "India", "700016")),

			new User("U003", "Sneha Reddy", "sneha.r@example.com", "9988776655", "sneha@789",
					new Address("A003", "8C", "Jubilee Hills", "Hyderabad", "India", "500033"))));

	@Autowired
	private UserRepo userRepo;
	
	public List<User> getAllUsers() {
		return userRepo.fetchAllUsers();
	}

	public User getUserById(String id) throws NoUserFoundException {
		return userRepo.findById(id).orElseThrow(() -> new NoUserFoundException("No user found with given id :" + id));
	}

	public String addUser(User newUser) {
		return userRepo.addUser(newUser) ?  "new user added successfully" : "Cannot add the user";
	}

	public String updateUser( String id,  User updatedUser) throws NoUserFoundException {
		User existingUser = users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
		if (existingUser == null)
			throw new NoUserFoundException("No user found with given id : " + id);
		else {
			existingUser.setName(updatedUser.getName());
			existingUser.setAddress(updatedUser.getAddress());
			existingUser.setEmail(updatedUser.getEmail());
			existingUser.setPassword(updatedUser.getPassword());
			existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
		}
		return "User update successfully";
	}

	public String deleteUser( String id) throws NoUserFoundException {
		User existingUser = users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
		if (existingUser == null)
			throw new NoUserFoundException("No user found with given id : " + id);
		else {
			users.remove(existingUser);
		}
		return "User deleted successfully";
	}

}
