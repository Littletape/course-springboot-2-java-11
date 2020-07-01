package com.andersoncardosolima.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersoncardosolima.course.entities.User;

// interface para criar um JPARepository para a entidade User 
public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
