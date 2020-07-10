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

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public User update(Long id, User obj) {
		User entity = repository.getOne(id); // prepara obj monitorado pelo jpa antes de acessar o banco
		updateData(entity, obj);
		return repository.save(entity); // salva no banco
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
