package com.andersoncardosolima.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersoncardosolima.course.entities.Product;
import com.andersoncardosolima.course.services.ProductService;

@RestController
@RequestMapping(value="/products") // caminho da url no navegador
public class ProductResource {
	
	@Autowired // anotação Spring para dependencia
	private ProductService service;
	
	@GetMapping // indica para o navegador que o metodo é do tipo Get no padrao JSON
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}") //Get recebera id
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}
}
