package com.andersoncardosolima.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersoncardosolima.course.entities.Order;
import com.andersoncardosolima.course.services.OrderService;

@RestController
@RequestMapping(value="/orders") // caminho da url no navegador
public class OrderResource {
	
	@Autowired // anotação Spring para dependencia
	private OrderService service;
	
	@GetMapping // indica para o navegador que o metodo é do tipo Get no padrao JSON
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}") //Get recebera id
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}
}
