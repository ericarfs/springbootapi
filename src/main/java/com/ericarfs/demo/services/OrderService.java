package com.ericarfs.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericarfs.demo.entities.Order;
import com.ericarfs.demo.exceptions.ResourceNotFoundException;
import com.ericarfs.demo.repositories.OrderRepository;


@Service
public class OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById(Long id){
		return orderRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Order with id " + id + " not found."));
	}

}