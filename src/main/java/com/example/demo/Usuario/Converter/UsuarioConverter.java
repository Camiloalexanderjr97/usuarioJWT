package com.example.demo.Usuario.Converter;

import com.example.demo.Usuario.Entity.Usuario;

import com.example.demo.Usuario.Repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("usuarioConverter")
public class UsuarioConverter {
    @Autowired
    @Qualifier("rolRepository")
    private RolRepository rolRepository;


   
}
