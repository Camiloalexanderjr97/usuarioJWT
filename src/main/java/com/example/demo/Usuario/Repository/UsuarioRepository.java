package com.example.demo.Usuario.Repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.Usuario.Entity.Usuario;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
	 Optional<Usuario> findByUsername(String nombre);
	
	  boolean existsByUsername(String nombre);
	
	
	
	  @Modifying
	  @Query(value = "  UPDATE usuario SET usuario.nombre = :name , usuario.password = :password, usuario.username =  :username WHERE usuario.id = :id",
//			  update Users u set u.status = ? where u.name = )
	    nativeQuery = true)
	  int updateUserSetStatusForNameNative(String name, String password, String username, Long id);

	  
	  @Modifying
	  @Query(value = "  INSERT INTO usuario_rol (usuario_id, rol_id) VALUES (:idUser, '1')",
//			  update Users u set u.status = ? where u.name = )
	    nativeQuery = true)
	  int insert(Long idUser);

	  
	  
	  
}
