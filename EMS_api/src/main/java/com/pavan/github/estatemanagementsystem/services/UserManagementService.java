package com.pavan.github.estatemanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pavan.github.estatemanagementsystem.repositories.UserRepo;
import com.pavan.github.estatemanagementsystem.exceptions.NoUserFoundException;
import com.pavan.github.estatemanagementsystem.entities.User;

@Service
public class UserManagementService {

	private final UserRepo userRepo;

    public UserManagementService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

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
		User existingUser = UserRepo.users.stream().filter(u -> u.getUserId().equals(id)).findFirst().orElse(null);
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
		User existingUser = UserRepo.users.stream().filter(u -> u.getUserId().equals(id)).findFirst().orElse(null);
		if (existingUser == null)
			throw new NoUserFoundException("No user found with given id : " + id);
		else {
			UserRepo.users.remove(existingUser);
		}
		return "User deleted successfully";
	}

}
