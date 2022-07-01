package com.example.demo.Usuario.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Usuario.Entity.Usuario;
import com.example.demo.Usuario.Repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    @Qualifier("usuarioRepository")
    private UsuarioRepository usuarioRepository;

    // public  UsuarioModel getUsusarioUsername(String username);

	public List<Usuario> getUsuarios() {
	        List<Usuario> listadoUser = usuarioRepository.findAll();
	        List<Usuario> lista = new ArrayList<>();

	      

	        return listadoUser;
	    }

	    public boolean deleteUsuario(Long id) {
	        boolean resultado =false;
	        try {
	                 usuarioRepository.deleteById(id);  
	                 resultado=true;
	        } catch (Exception e) {
	            //TODO: handle exception
	        }
	         return resultado;
	    }

    public  Usuario crearUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
    
    
    public boolean editarUsuario(Usuario user) {
    	
    	boolean resultado =false;
    	System.out.println(user.toString()+"-------1---------");
    	if(	usuarioRepository.updateUserSetStatusForNameNative(user.getName(),user.getPassword(),user.getUsername(),user.getId())!=1) {
    		resultado=true;
    	}
    
    	return  resultado;
    }
    
    public void actualizarRol(Long id) {
		usuarioRepository.insert(id);

    }

    public  boolean loadUserByUsername(String username) {
		System.out.println("-----------------------------Entra");

    	boolean resultado=false;
    	List<Usuario> user =  	usuarioRepository.findAll();
    	for(Usuario lista : user) {
    		if(lista.getUsername().equalsIgnoreCase(username)) {
    			resultado=true;
    		}
    	}
		return resultado;
	}

	public boolean existByUsername(String nombre) {
		return usuarioRepository.existsByUsername(nombre);
	}
	
	public void save(Usuario user) {
		usuarioRepository.save(user);
	}
	
	public Usuario buscarById(Long id) {
		System.out.println("_________________entra_____________________________"+id);

		return usuarioRepository.findById(id).get();
	}

    
}
