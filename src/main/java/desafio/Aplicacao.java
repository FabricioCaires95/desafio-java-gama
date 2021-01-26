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
		u.setCpf("1");
		u.setNome("alguem");
		u.setLogin("aa");
		u.setSenha("xxxx");
		
		u.addConta(new Conta("123",897.08));
		s.incluir(u);
		
		UsuarioRepository ur = new UsuarioRepository();
		
		ContaRepository cr = new ContaRepository();
		
		Conta c =new Conta("098098",897989.0);
		
		cr.incluir(c);
	}
		
}
