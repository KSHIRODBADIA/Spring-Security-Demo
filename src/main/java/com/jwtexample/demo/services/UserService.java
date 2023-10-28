package com.jwtexample.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwtexample.demo.entities.User;
import com.jwtexample.demo.repositories.UserRepository;

@Service
public class UserService {

	//private List<User> store = new ArrayList<>();
	
//	public UserService() {
//		store.add(new User(UUID.randomUUID().toString(), "kshirod","k@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(), "kshirod1","k1@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(), "kshirod2","k2@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(), "kshirod3","k3@gmail.com"));
//	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User createUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
