package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Offerte")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull (message = "Non puoi lasciare il campo vuoto")
	@Column (name = "INIZIO_OFFERTA", nullable = false)
	private LocalDate inizio;
	
	@NotNull (message = "Non puoi lasciare il campo vuoto")
	@Column (name = "FINE_OFFERTA", nullable = false)
	private LocalDate fine;
	
	@NotBlank (message = "Non puoi lasciare il campo vuoto")
	@Column (name = "OFFERTA", nullable = false)
	private String offerta;

	
	@ManyToOne
	@JoinColumn(name = "Pizza.id", nullable = false)
	private Pizza pizza;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getInizio() {
		return inizio;
	}

	public void setInizio(LocalDate inizio) {
		this.inizio = inizio;
	}

	public LocalDate getFine() {
		return fine;
	}

	public void setFine(LocalDate fine) {
		this.fine = fine;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	
}
