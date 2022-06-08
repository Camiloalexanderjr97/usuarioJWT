package com.example.demo.Usuario.Repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.Usuario.Entity.Usuario;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
	 Optional<Usuario> findByUsername(String nombre);
	
	  boolean existsByUsername(String nombre);
	
	

}
