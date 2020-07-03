package com.andersoncardosolima.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersoncardosolima.course.entities.Category;
import com.andersoncardosolima.course.services.CategoryService;

@RestController
@RequestMapping(value="/categories") // caminho da url no navegador
public class CategoryResource {
	
	@Autowired // anotação Spring para dependencia
	private CategoryService service;
	
	@GetMapping // indica para o navegador que o metodo é do tipo Get no padrao JSON
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}") //Get recebera id
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}
}
