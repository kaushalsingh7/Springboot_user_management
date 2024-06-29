package com.stack.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.stack.backend.exception.UserNotFoundExceptions;
import com.stack.backend.model.User;
import com.stack.backend.repository.UserRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	@Autowired
	UserRepo repo;

	@PostMapping("users")
	public User newUser(@RequestBody User newUser) {
		return repo.save(newUser);
	}
	@GetMapping("/users")
	List<User>getAllUSers(){
		return repo.findAll();
	}
	@GetMapping("/users/{id}")
	 User getUserById(@PathVariable Long id) {
		return repo.findById(id).orElseThrow(()-> new UserNotFoundExceptions(id));
	}
	@PutMapping("/users/{id}")
	User updateUser(@RequestBody User newUser , @PathVariable Long id) {
		return repo.findById(id).map(user->{
			user.setName(newUser.getName());
			user.setEmail(newUser.getEmail());
			user.setUsername(newUser.getUsername());
			return repo.save(user);
		}).orElseThrow(()->new UserNotFoundExceptions(id));
	}
	@DeleteMapping("users/{id}")
	String deleteUser(@PathVariable Long id) {
		if(!repo.existsById(id)) {
			throw new UserNotFoundExceptions(id);
		}
	 repo.deleteById(id);
	 return "User deleted with id "+ id ;
	}
}
