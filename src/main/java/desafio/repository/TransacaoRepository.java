package desafio.repository;

import javax.persistence.Query;

import desafio.model.TipoPlanoConta;
import desafio.model.Transacao;

public class TransacaoRepository extends RepositorioGenerico<Transacao>{
	
	public boolean existsTipoPlanoConta(TipoPlanoConta tipoPlanoConta) {
		Query query = em.createQuery("SELECT u FROM TipoPlanoConta u where u.finalidade = :finalidade"); 
		query.setParameter("finalidade", tipoPlanoConta);
		return query.getResultList().size() > 0;
	}
}
