package com.shriram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shriram.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
