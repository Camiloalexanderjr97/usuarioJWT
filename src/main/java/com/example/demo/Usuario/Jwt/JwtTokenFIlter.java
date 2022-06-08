package com.example.demo.Usuario.Jwt;

import java.io.IOException;
import java.lang.annotation.Target;

import javax.servlet.FilterChain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.Usuario.ServiceImpl.UsuarioServiceImpl;

import org.apache.commons.collections4.sequence.ReplacementsFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtTokenFIlter extends OncePerRequestFilter {



    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Autowired
	private UsuarioServiceImpl usuarioService;

    @Autowired
    JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                try {
                    String token =getToken(request);
                    if(token!=null && jwtProvider.validateToken(token)){
                        String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                        UserDetails userDetails =  usuarioService.loadUserByUsername(nombreUsuario);
                        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities() );
                        SecurityContextHolder.getContext().setAuthentication(auth);

                    }
                } catch (Exception e) {
                	logger.error("Fail en el metodo doFilter");
                }
                filterChain.doFilter(request, response);
        
    }

    private String getToken(HttpServletRequest request){
        String header  = request.getHeader("Authorization");
        if(header!= null && header.startsWith("Bearer"))
              return header.replace( "Bearer", "");
        return null;
    }
    
}
