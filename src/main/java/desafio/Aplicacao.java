package desafio;

import desafio.model.Conta;
import desafio.model.Usuario;
import desafio.service.UsuarioService;

public class Aplicacao {
	public static void main(String[] args) {
		UsuarioService s = new UsuarioService();
		Usuario u = new Usuario();
		u.setCpf("15945675398");
		u.setNome("Rafa");
		u.setLogin("rafael");
		u.setSenha("xxxxxx");
		u.addConta(new Conta("123",1000.08, "Conta Corrente"));
		s.incluir(u);
	}
		
}
