package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Pizza;
import com.example.demo.model.Sale;
import com.example.demo.repository.PizzaRepository;
import com.example.demo.repository.SaleRepository;

import jakarta.persistence.Entity;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sale")
public class SaleController {
	
		@Autowired
		private SaleRepository saleRepository;
		
		@Autowired
		private PizzaRepository pizzaRepository;
		
		@GetMapping
		public String getSaleList(Model model) {
			List<Sale> saleList = saleRepository.findAll();
			model.addAttribute("list", saleList);
			
			return"/sale/list";
		}
		
		@GetMapping("/create")
		public String create(Model model) {
			
			List<Pizza> pizza = pizzaRepository.findAll();
			
			model.addAttribute("sale", new Sale());
			model.addAttribute("pizza", pizza);
			
			return "/sale/sale";
		}
		
		@PostMapping("/create")
		public String offerta(@Valid @ModelAttribute("sale") Sale sale,
				BindingResult bindingResult, Model model) {
				
			if(bindingResult.hasErrors()) {
				
				return "/sale/sale";
			}
			
			saleRepository.save(sale);
			
			return "redirect:/pizza";
		}
}
