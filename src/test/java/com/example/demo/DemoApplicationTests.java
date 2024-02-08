package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.poi.sl.usermodel.ObjectMetaData.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Controller.UsuarioController;
import com.example.demo.Usuario.Entity.Usuario;
import com.example.demo.Usuario.Repository.UsuarioRepository;
import com.example.demo.Usuario.Service.UsuarioService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DemoApplicationTests {

	
	@Autowired(required = false)
	UsuarioService user;

	
	
	@Autowired
	private TestEntityManager entity;
	
	UsuarioController control = new UsuarioController();
	@Test
	public void prueba() {
		user = new UsuarioService();

		Usuario aux =getuser();
		try {

			Usuario getFromDb = control.buscarByID(aux.getId()).getBody();
			assertThat(getFromDb.getName()).isEqualTo(aux.getName());
				
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("---------------------------"+e);
		}
		
		
	}
	
	private  Usuario getuser() {
		Usuario u = new Usuario();
		
		u.setId(2L);
		u.setName("Jaime");
		u.setPassword("1234");
		u.setUsername("jaime");
		
		return u;
		
	}

}
