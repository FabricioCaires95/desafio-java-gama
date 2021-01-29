package desafio.repository;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import desafio.model.Conta;
import desafio.model.Usuario;

public class ContaRepository extends RepositorioGenerico<Conta> {
	public boolean exists(String numero) {
		Query query = em.createQuery("SELECT u From Conta u where u.numero = :numero"); // JPQL
		query.setParameter("numero", numero);
		return query.getResultList().size() != 0;
	}
	
	public boolean realizarTransferencia(String numero_conta, double valor) {
		em.getTransaction().begin();
		Query queryUpdate = em.createQuery("UPDATE Conta u SET u.saldo = u.saldo + :valor WHERE e.numero = :numero_conta");
		if (valor == 0) {
			return true;
		}

		Query querySelect = em.createQuery("SELECT u from Conta u WHERE u.numero = :numero_conta");
		querySelect.setParameter("numero_conta", numero_conta);
		Conta c = null;
		try {
			c = (Conta) querySelect.getSingleResult();
		} catch (NoResultException | NonUniqueResultException nre) {
			c = null;
		}
		double saldoAtual = c.getSaldo();
		if (saldoAtual - valor < 0) {
			return false;
		}
		c.setSaldo(saldoAtual + valor);
		queryUpdate.setParameter("saldo", c.getSaldo());
		queryUpdate.setParameter("numero_conta", c.getNumero());
		int rowsUpdated = queryUpdate.executeUpdate();
		em.getTransaction().commit();
		
		return rowsUpdated != 0;
	}
}
