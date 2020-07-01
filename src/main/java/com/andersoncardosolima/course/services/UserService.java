package com.andersoncardosolima.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersoncardosolima.course.entities.User;
import com.andersoncardosolima.course.repositories.UserRepository;

@Service // registra serviço como componente do Spring facilitando injeção de dependencia
public class UserService {

	@Autowired // anotação Spring para dependencia
	private UserRepository repository;

	// busca todos os usuarios
	public List<User> findAll() {
		return repository.findAll();
	}

	// busca usuarios pelo id
	public User findbyId(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
