package desafio.repository;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import desafio.model.Conta;
import desafio.model.Transacao;

public class TransacaoRepository extends RepositorioGenerico<Transacao>{
	private ContaRepository crep = new ContaRepository();
	public boolean existsTipoPlanoConta(String tipoPlanoConta) {
		Query query = em.createQuery("SELECT u FROM TipoPlanoConta u where u.finalidade = :finalidade"); 
		query.setParameter("finalidade", tipoPlanoConta);
		return query.getResultList().size() > 0;
	}
	
	public Conta transferenciaDuasContas(String conta, String contaDestino, Double valor) {
		Conta contaUso = null;
		Conta contaFinal = null;
		if (valor < 0) {
			return contaUso;
		}
		Query queryConta = em.createQuery("SELECT c FROM Conta c where c.numero = :conta");
		Query queryContaDestino = em.createQuery("SELECT c FROM Conta c where c.numero = :conta");
		queryConta.setParameter("conta", conta);
		queryContaDestino.setParameter("conta", contaDestino);
		try {
			contaUso = (Conta) queryConta.getSingleResult();
			contaFinal = (Conta) queryContaDestino.getSingleResult();
		} catch (NoResultException | NonUniqueResultException nre) {
			// TODO: handle exception
			contaUso = null;
            contaFinal = null;
		}
		crep.realizarTransferencia(contaUso.getNumero(), valor*-1);
		crep.realizarTransferencia(contaFinal.getNumero(), valor);
		contaUso.setSaldo(contaUso.getSaldo() + valor*-1);
		
		return contaUso;
	}
	
	public boolean pagamento(String conta, Double valor) {
		//pagamento padrão
		return crep.realizarTransferencia(conta, valor);
	}
}
