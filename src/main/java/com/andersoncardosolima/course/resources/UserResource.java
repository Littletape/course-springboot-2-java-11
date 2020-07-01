package com.andersoncardosolima.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersoncardosolima.course.entities.User;
import com.andersoncardosolima.course.services.UserService;

@RestController
@RequestMapping(value="/users") // caminho da url no navegador
public class UserResource {
	
	@Autowired // anotação Spring para dependencia
	private UserService service;
	
	@GetMapping // indica para o navegador que o metodo é do tipo Get no padrao JSON
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}") //Get recebera id
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}
}
