package com.ericarfs.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericarfs.demo.entities.Category;
import com.ericarfs.demo.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	public CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> listCategorys(){
		List<Category> list = categoryService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> listById(@PathVariable Long id){
		Category u = categoryService.findById(id);
		return ResponseEntity.ok().body(u);
	}
}
