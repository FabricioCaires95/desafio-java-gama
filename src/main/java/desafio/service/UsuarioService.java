package desafio.service;

import java.util.List;

import desafio.model.Conta;
import desafio.model.Usuario;
import desafio.repository.ContaRepository;
import desafio.repository.UsuarioRepository;
import desafio.utils.TextoUtils;

public class UsuarioService {
	private UsuarioRepository rep = new UsuarioRepository();
	private ContaRepository crep = new ContaRepository();
	public void incluir(Usuario usuario) {
		boolean comprimentoValido = TextoUtils.validaComprimento(usuario.getLogin(), 20);
		boolean cpfValido = TextoUtils.validaCpf(usuario.getCpf());
		if(!comprimentoValido && cpfValido)
			throw new IllegalArgumentException();
		//Usuario udb = rep.buscarByLogin(usuario.getLogin());
		
		if(rep.exists(usuario.getLogin()))
			throw new IllegalStateException("Já existe um usuario com o login " + usuario.getLogin());
		Conta cs = usuario.getContas().get(0);
		if(crep.exists(cs.getNumero()))
			throw new IllegalStateException("Já existe uma conta: " + cs.getNumero());
		rep.incluir(usuario);
		
		//Conta c = usuario.getConta();
		//crep.incluir(c);
		System.out.println("FIM");
		//repositorio.salvar(usuario);
	}
	
}
