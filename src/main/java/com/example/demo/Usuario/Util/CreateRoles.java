package com.example.demo.Usuario.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Usuario.Entity.Rol;
import com.example.demo.Usuario.Login.RolNombre;
import com.example.demo.Usuario.Service.RolService;


@Component
public class CreateRoles implements CommandLineRunner {

	@Autowired
	RolService rolService;
	
	@Override
	public void run(String... args) throws Exception {
		Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
		Rol rolUser = new Rol(RolNombre.ROLE_USER);
//		rolService.save(rolAdmin);
//		rolService.save(rolUser);
		// TODO Auto-generated method stub
		
	}
	

}
