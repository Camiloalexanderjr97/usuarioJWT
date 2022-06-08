package com.example.demo.Usuario.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.demo.Usuario.Login.RolNombre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Rol {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "rolNombre")
    private RolNombre rolNombre;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
	public RolNombre getRolNombre() { 
		return rolNombre;
	}
	public void setRolNombre(RolNombre rolNombre) {
		this.rolNombre = rolNombre;
	}
	public Rol(RolNombre rolNombre) {
		super();
		this.rolNombre = rolNombre;
	}
	public Rol() {
		super();
	}


    
}
