package com.example.demo.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {

	@Id
	private Integer id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@ManyToMany (fetch = FetchType.EAGER)
	private Set<Role> roles;

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Set<Role> getRoles() {
		return roles;
	}
	
	
}
