package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pizza;
import com.example.demo.repository.PizzaRepository;
import com.example.demo.response.Payload;
import com.example.demo.service.PizzaService;

@RestController
@CrossOrigin
@RequestMapping("/api/pizza")
public class PizzaRestController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/pizza")
	public ResponseEntity<Payload<List<Pizza>>> getAll(){
		
		List<Pizza> pizzaList = pizzaService.findall();
		
		return ResponseEntity.ok(new Payload<List<Pizza>>(pizzaList, null, HttpStatus.OK));
	}
	
	 @GetMapping("/{id}")
	 public ResponseEntity<Payload<Pizza>> getId(@PathVariable("id") Integer pizzaId){
	 
		 Optional<Pizza> pizza = pizzaService.findById(pizzaId);
	    
		 if (pizza.isPresent()) {
	    	
	      return ResponseEntity.ok(new Payload<Pizza>(pizza.get(), null, HttpStatus.OK));   
	      
	    } else {
	            return new ResponseEntity<>(new Payload<Pizza>(null, "Pizza con id " + pizzaId + 
	            " non trovata", HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
	       }
	 }
}
