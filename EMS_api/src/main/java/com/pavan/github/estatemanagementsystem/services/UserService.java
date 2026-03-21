package com.pavan.github.estatemanagementsystem.services;

import java.util.List;

import com.pavan.github.estatemanagementsystem.repositories.UserRepo;
import org.springframework.stereotype.Service;

import com.pavan.github.estatemanagementsystem.exceptions.NoUserFoundException;
import com.pavan.github.estatemanagementsystem.entities.User;

@Service
public class UserService {

	private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User getUserById(String id) throws NoUserFoundException {
		return userRepo.findById(id).orElseThrow(() -> new NoUserFoundException("No user found with given id :" + id));
	}

	public String addUser(User newUser) {
		userRepo.save(newUser);
		return "User added successfully";
	}

	public String updateUser( String id,  User updatedUser) throws NoUserFoundException {
		User existingUser = userRepo.findById(id).orElse(null);
		if (existingUser == null)
			throw new NoUserFoundException("No user found with given id : " + id);
		else {
			userRepo.save(updatedUser);
		}
		return "User update successfully";
	}

	public String deleteUser( String id) throws NoUserFoundException {
		User existingUser = userRepo.findById(id).orElse(null);
		if (existingUser == null)
			throw new NoUserFoundException("No user found with given id : " + id);
		else {
			userRepo.delete(existingUser);
		}
		return "User deleted successfully";
	}

}
