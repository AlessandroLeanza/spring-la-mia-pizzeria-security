package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Pizza;
import com.example.demo.model.Sale;
import com.example.demo.repository.PizzaRepository;
import com.example.demo.repository.SaleRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pizza")
public class PizzaController {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Autowired
	private SaleRepository saleRepository;
	
	@GetMapping
	public String index(Model model) {
		List <Pizza> pizzeList = pizzaRepository.findAll();
		model.addAttribute("list", pizzeList);
		return "/Pizza/index";
	}
	
	@GetMapping ("/create")
	public String create(Model model) {
		model.addAttribute("form", new Pizza());
		return "/Pizza/create";
	}
	
	@PostMapping("/create")
    public String store(@Valid @ModelAttribute("form") Pizza pizzaForm, 
    		BindingResult bindingresult, Model model) {
        
        if (bindingresult.hasErrors()) {
            return "/Pizza/create";
        }

        pizzaRepository.save(pizzaForm);

        return "redirect:/pizza";

    }
	
	@GetMapping ("/show/{id}")
	public String show(@PathVariable ("id")Integer id, Model model) {
		model.addAttribute("show", pizzaRepository.getReferenceById(id));
		return "Pizza/show";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("pizza", pizzaRepository.getReferenceById(id));
		
		return "/pizza/edit";
	}
	
	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("pizza") Pizza pizza,
			BindingResult bindingResult,
			Model model) {
		
		if(bindingResult.hasErrors()) {
			return "/pizza/edit";
		}
		
		pizzaRepository.save(pizza);
		
		return "redirect:/pizza";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		
		pizzaRepository.deleteById(id);
		
		return "redirect:/pizza";
	}
	
	@GetMapping("/sale/{id}")
	public String getSale (@PathVariable("id") Integer id, Model model) {
		Pizza pizza = pizzaRepository.findById(id).get();
		Sale sale = new Sale();
		sale.setPizza(pizza);
		
		model.addAttribute("sale", sale);
		
		return "/Pizza/index";
				
	}
	
	@PostMapping("/sale/{id}")
	public String newSale(@Valid @ModelAttribute("sale") Sale sale,
			BindingResult bindingResult,
			Model model) {
		
		if(bindingResult.hasErrors()) {
			return "/Pizza/index";
		}
		
		saleRepository.save(sale);
		
		return "redirect:/pizza";
	}
}
