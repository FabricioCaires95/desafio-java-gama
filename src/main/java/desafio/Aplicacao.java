package desafio;

import desafio.model.Conta;
import desafio.model.Usuario;
import desafio.repository.ContaRepository;
import desafio.repository.UsuarioRepository;
import desafio.service.UsuarioService;

public class Aplicacao {
	public static void main(String[] args) {
		UsuarioService s = new UsuarioService();
		Usuario u = new Usuario();
		u.setCpf("12345");
		u.setNome("rafael");
		u.setLogin("aaaab");
		u.setSenha("1234");
		
		u.addConta(new Conta("1521",900000.08));
		s.incluir(u);
		
		ContaRepository cr = new ContaRepository();
		
		Conta c =new Conta("098098",897989.0);
		
		cr.incluir(c);
	}
		
}
