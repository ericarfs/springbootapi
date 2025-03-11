package com.ericarfs.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericarfs.demo.entities.Product;
import com.ericarfs.demo.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> listProducts(){
		List<Product> list = productService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> listById(@PathVariable Long id){
		Product u = productService.findById(id);
		return ResponseEntity.ok().body(u);
	}
}
