package com.example.demo.Usuario.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Usuario.Entity.Rol;
import com.example.demo.Usuario.Entity.Usuario;
import com.example.demo.Usuario.Login.RolNombre;
import com.example.demo.Usuario.Repository.RolRepository;

@Service
@Transactional
public class RolService {
    
	@Autowired
	RolRepository rolRepository;
    // public abstract UsuarioModel getUsusarioUsername(String username);

   

    public Optional<Rol> getRolByName(RolNombre nombre){
    	return rolRepository.findByRolNombre(nombre);
    }
    
    public void save(Rol rol)
    {
    	rolRepository.save(rol);
    }
    
}
