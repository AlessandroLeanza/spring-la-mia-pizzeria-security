package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pizza;
import com.example.demo.repository.PizzaRepository;

@Service
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;

	@Override
	public Optional<Pizza> findById(Integer Id) {
		// TODO Auto-generated method stub
		return pizzaRepository.findById(Id);
	}

	@Override
	public List<Pizza> findall() {
		// TODO Auto-generated method stub
		return pizzaRepository.findAll();
	}
	
	
}
