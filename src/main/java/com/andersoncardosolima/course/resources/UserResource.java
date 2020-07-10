package com.andersoncardosolima.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andersoncardosolima.course.entities.User;
import com.andersoncardosolima.course.services.UserService;

@RestController
@RequestMapping(value = "/users") // caminho da url no navegador
public class UserResource {

	@Autowired // anotação Spring para dependencia
	private UserService service;

	@GetMapping // indica para o navegador que o metodo é do tipo GET(html) no padrao JSON
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();

		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}") // Get recebera id
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping // indica para o navegador que o metodo é do tipo POST(html) no padrao JSON
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);

		// nessessario para retornar resposta 201 (Created new resource) ao enviar o
		// POST pelo Json
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}") // indica para o navegador que o metodo é do tipo Delete(html) no padrao JSON
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}") // indica para o navegador que o metodo é do tipo Put(html) no padrao JSON
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
