package com.ericarfs.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ericarfs.demo.entities.OrderItem;



@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
}