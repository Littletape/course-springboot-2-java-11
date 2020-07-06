package com.andersoncardosolima.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersoncardosolima.course.entities.Product;
import com.andersoncardosolima.course.repositories.ProductRepository;

@Service // registra serviço como componente do Spring facilitando injeção de dependencia
public class ProductService {

	@Autowired // anotação Spring para dependencia
	private ProductRepository repository;

	// busca todos os usuarios
	public List<Product> findAll() {
		return repository.findAll();
	}

	// busca usuarios pelo id
	public Product findbyId(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
