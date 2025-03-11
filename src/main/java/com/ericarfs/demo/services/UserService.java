package com.ericarfs.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ericarfs.demo.entities.User;
import com.ericarfs.demo.exceptions.DatabaseException;
import com.ericarfs.demo.exceptions.ResourceNotFoundException;
import com.ericarfs.demo.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findByEmail(String email){
		return userRepository.findByEmail(email)
				.orElseThrow(()-> new ResourceNotFoundException("User with email "+email+" not found!"));
	}
	
	public User findById(Long id){
		return userRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User with id "+id+" not found!"));
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = userRepository.getReferenceById(id);
			updateData(entity,obj);
			return userRepository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

	public void delete(Long id) {
		if(!userRepository.existsById(id)) {
			throw new ResourceNotFoundException("User "+id+" not found!");
		}
		try {
			userRepository.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}


}