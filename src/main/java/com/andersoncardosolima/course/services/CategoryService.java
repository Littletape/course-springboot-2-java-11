package com.andersoncardosolima.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersoncardosolima.course.entities.Category;
import com.andersoncardosolima.course.repositories.CategoryRepository;

@Service // registra serviço como componente do Spring facilitando injeção de dependencia
public class CategoryService {

	@Autowired // anotação Spring para dependencia
	private CategoryRepository repository;

	// busca todos os usuarios
	public List<Category> findAll() {
		return repository.findAll();
	}

	// busca usuarios pelo id
	public Category findbyId(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
