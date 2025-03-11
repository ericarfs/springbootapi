package com.ericarfs.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericarfs.demo.entities.Category;
import com.ericarfs.demo.exceptions.ResourceNotFoundException;
import com.ericarfs.demo.repositories.CategoryRepository;


@Service
public class CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id){
		return categoryRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Category with id "+id+" not found!"));
	}


}