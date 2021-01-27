package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import desafio.model.Usuario;
import desafio.service.UsuarioService;

public class UsuarioTest {
	@Test
	public void loginComprimentoTest() {
		
		Usuario user = new Usuario();
		user.setLogin("gso");
		user.setSenha("123");
		UsuarioService service = new UsuarioService();
		
		service.incluir(user);
		
		assertTrue(true);
		
	}
	@Test
	public void loginComprimentoIvalidoTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			Usuario user = new Usuario();
			user.setLogin("gleysonsampaiooliveira");
			UsuarioService service = new UsuarioService();
			
			service.incluir(user);
		});
		
		
		//assertTrue(false);
		
	}
	
	
}
