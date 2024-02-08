package com.example.demo.Usuario.ServiceImpl;


import com.example.demo.Usuario.Entity.Usuario;
import com.example.demo.Usuario.Repository.UsuarioRepository;
import com.example.demo.Usuario.Util.UsuarioPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service()
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
       Usuario user =usuarioRepository.findByUsername(username).get();

        return UsuarioPrincipal.build(user);
    }


    // @Override
    // public UsuarioModel getUsusarioUsername(String username) {
    // UsuarioModel user = usuarioRepository.findByUsuarioUsername(username);
    // return user;
    // }

}
