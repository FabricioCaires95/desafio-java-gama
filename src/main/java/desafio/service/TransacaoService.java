package desafio.service;

import desafio.model.Transacao;
import desafio.repository.ContaRepository;
import desafio.repository.TransacaoRepository;

public class TransacaoService {
	private TransacaoRepository trep = new TransacaoRepository();
	private ContaRepository crep = new ContaRepository();
	public void transferencia(Transacao transacao) {
		if (!crep.exists(transacao.getNumero().toString())) {
			throw new IllegalStateException("numero de conta não encontrado " + transacao.getNumero());
		}
		if(!trep.existsTipoPlanoConta(transacao.getTipoPlanoConta())) {
			throw new IllegalStateException("Tipo de plano de conta não encontrado " + transacao.getTipoPlanoConta());
		}
		if (transacao.getTipoPlanoConta().toString() == "Transferencia") {
			//realizar transferencia entre contas
			if (!crep.exists(transacao.getNumero_destino().toString())) {
				throw new IllegalStateException("numero de conta não encontrado" + transacao.getNumero());
			}
			trep.transferenciaDuasContas(transacao.getNumero().toString(), transacao.getNumero_destino().toString(), transacao.getValor());
			trep.incluir(transacao);
		} else {
			//realizar outras transferencias
			trep.incluir(transacao);
		}
	}

}
