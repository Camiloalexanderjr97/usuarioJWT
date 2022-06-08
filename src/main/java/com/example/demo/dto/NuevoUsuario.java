package com.example.demo.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;


import com.example.demo.Usuario.Entity.Rol;

public class NuevoUsuario {
	
	@NotEmpty
	private Long id;

	@NotEmpty
    private String name;

	@NotEmpty
    private String username;
	

	@NotEmpty
    private String password;
	
	private String rol;
	


    private Set<Rol> roles = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
    
	
    
    
}
