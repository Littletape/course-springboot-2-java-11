package com.andersoncardosolima.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersoncardosolima.course.entities.Product;

// interface para criar um JPARepository para a entidade User 
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
}
