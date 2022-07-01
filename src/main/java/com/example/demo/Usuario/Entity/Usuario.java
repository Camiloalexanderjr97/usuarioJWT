package com.example.demo.Usuario.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)                                                                                                                                     
    private Long id;

    @NotNull
    @Column(name = "nombre")
    private String name;

    @NotNull
    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull 
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns= @JoinColumn(name= "usuario_id"),
    inverseJoinColumns = @JoinColumn(name ="rol_id"))
    private  Set<Rol> roles = new HashSet<>();


    
    
    
    
    
    
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



    
	public Usuario(@NotNull String name, @NotNull String username, @NotNull String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}
	public Usuario(@NotNull Long id,@NotNull String name, @NotNull String username, @NotNull String password) {
		super();
		this.id=id;
		this.name = name;
		this.username = username;
		this.password = password;
	}


	public Usuario() {
    	
    }


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", roles="
				+ roles + "]";
	}
	
	
}