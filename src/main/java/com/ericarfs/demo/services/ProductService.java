package com.ericarfs.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericarfs.demo.entities.Product;
import com.ericarfs.demo.repositories.ProductRepository;
import com.ericarfs.demo.exceptions.ResourceNotFoundException;


@Service
public class ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id){
		return productRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Product with id " + id + " not found."));
	}
}