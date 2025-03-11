package com.ericarfs.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ericarfs.demo.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	Optional<Product> findByName(String name);	
}