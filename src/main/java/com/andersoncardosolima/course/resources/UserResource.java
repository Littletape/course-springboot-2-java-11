package com.andersoncardosolima.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersoncardosolima.course.entities.User;

@RestController
@RequestMapping(value="/users") // caminho da url no navegador
public class UserResource {
	
	@GetMapping // indica para o navegador que o metodo é do tipo Get no padrao JSON
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "12345");
		return ResponseEntity.ok(u);
	}
}
