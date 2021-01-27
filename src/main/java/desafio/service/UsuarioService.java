package desafio.service;

import desafio.model.Usuario;
import desafio.repository.UsuarioRepository;
import desafio.utils.TextoUtils;

public class UsuarioService {
	private UsuarioRepository rep = new UsuarioRepository();
	
	public void incluir(Usuario usuario) {
		boolean comprimentoValido = TextoUtils.validaComprimento(usuario.getLogin(), 20);
		boolean cpfValido = TextoUtils.validaCpf(usuario.getCpf());
		if(!comprimentoValido && cpfValido)
			throw new IllegalArgumentException();
		//Usuario udb = rep.buscarByLogin(usuario.getLogin());
		
		if(rep.exists(usuario.getLogin()))
			throw new IllegalStateException("Já existe um usuario com o login " + usuario.getLogin());
		
		rep.incluir(usuario);
		
		//Conta c = usuario.getConta();
		//crep.incluir(c);
		System.out.println("FIM");
		//repositorio.salvar(usuario);
	}
	
}
