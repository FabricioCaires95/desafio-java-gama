package desafio.service;

import desafio.model.Transacao;
import desafio.repository.TransacaoRepository;

public class TransacaoService {
	private TransacaoRepository trep = new TransacaoRepository();
	
	public void incluir(Transacao transacao) {
		
		trep.incluir(transacao);
	}
}
