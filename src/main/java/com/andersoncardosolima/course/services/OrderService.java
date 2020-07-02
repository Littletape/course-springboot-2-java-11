package com.andersoncardosolima.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersoncardosolima.course.entities.Order;
import com.andersoncardosolima.course.repositories.OrderRepository;

@Service // registra serviço como componente do Spring facilitando injeção de dependencia
public class OrderService {

	@Autowired // anotação Spring para dependencia
	private OrderRepository repository;

	// busca todos os usuarios
	public List<Order> findAll() {
		return repository.findAll();
	}

	// busca usuarios pelo id
	public Order findbyId(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
