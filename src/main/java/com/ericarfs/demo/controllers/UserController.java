package com.ericarfs.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericarfs.demo.entities.User;
import com.ericarfs.demo.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> listUsers(){
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> listById(@PathVariable Long id){
		User u = userService.findById(id);
		return ResponseEntity.ok().body(u);
	}
}
