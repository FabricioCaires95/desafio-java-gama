package desafio.service;

import desafio.model.Transacao;
import desafio.repository.TransacaoRepository;

public class TransacaoService {
	private TransacaoRepository trep = new TransacaoRepository();
	
	public void incluir(Transacao transacao) {
		if(!trep.existsTipoPlanoConta(transacao.getTipoPlanoConta())) {
			throw new IllegalStateException("Tipo de plano de conta não encontrado" + transacao.getTipoPlanoConta());
		}
		trep.incluir(transacao);
	}

}
