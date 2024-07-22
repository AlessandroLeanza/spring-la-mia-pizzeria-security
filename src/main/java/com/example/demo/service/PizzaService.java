package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Pizza;

public interface PizzaService {

	public Optional<Pizza> findById(Integer Id);
	
	public List<Pizza> findall();
}
