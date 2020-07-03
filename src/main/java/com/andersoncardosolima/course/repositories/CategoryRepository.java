package com.andersoncardosolima.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersoncardosolima.course.entities.Category;

// interface para criar um JPARepository para a entidade User 
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	
}
