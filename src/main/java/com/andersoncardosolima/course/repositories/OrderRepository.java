package com.andersoncardosolima.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersoncardosolima.course.entities.Order;

//interface para criar um JPARepository para a entidade User
public interface OrderRepository extends JpaRepository<Order, Long>{

}
