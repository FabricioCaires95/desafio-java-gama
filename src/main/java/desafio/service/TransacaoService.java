package desafio.service;

import desafio.model.Transacoes;
import desafio.repository.TransacaoRepository;

public class TransacaoService {
	private TransacaoRepository trep = new TransacaoRepository();
	
	public void incluir(Transacoes transacao) {
		
		trep.incluir(transacao);
	}
}
