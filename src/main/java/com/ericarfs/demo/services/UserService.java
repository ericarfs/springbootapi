package com.ericarfs.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericarfs.demo.entities.User;
import com.ericarfs.demo.repositories.UserRepository;


@Service
public class UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public Optional<User> findByEmail(String email){
		return userRepository.findByEmail(email);
	}
	
	public User findById(Long id){
		Optional<User> obj = userRepository.findById(id);
		return obj.get();
	}


}