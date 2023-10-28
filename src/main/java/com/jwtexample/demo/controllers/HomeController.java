package com.jwtexample.demo.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtexample.demo.entities.User;
import com.jwtexample.demo.services.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getUser() {
		System.out.println("Getting All users");
		return this.userService.getUsers();
	}
	
	@GetMapping("/current-user")
	public String getCurrentUser(Principal principal) {
		System.out.println("Getting Current users");
		return principal.getName();
	}
}
