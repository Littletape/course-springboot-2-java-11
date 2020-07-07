package com.andersoncardosolima.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersoncardosolima.course.entities.OrderItem;

// interface para criar um JPARepository para a entidade OrderItem 
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
	
}
