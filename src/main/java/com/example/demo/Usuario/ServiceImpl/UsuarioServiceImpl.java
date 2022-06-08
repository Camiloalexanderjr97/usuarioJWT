package com.example.demo.Usuario.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.Usuario.Converter.RolConverter;
import com.example.demo.Usuario.Converter.UsuarioConverter;
import com.example.demo.Usuario.Entity.Usuario;
import com.example.demo.Usuario.Repository.RolRepository;
import com.example.demo.Usuario.Repository.UsuarioRepository;
import com.example.demo.Usuario.Service.UsuarioService;
import com.example.demo.Usuario.Util.UsuarioPrincipal;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service()
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    @Qualifier("rolConverter")
    private RolConverter rolConverter;

    @Autowired
    @Qualifier("usuarioConverter")
    private UsuarioConverter usuarioConverter;

    



    



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
