package desafio.repository;

import javax.persistence.EntityManager;

import desafio.utils.ConexaoFactory;

public class RepositorioGenerico <T> {
	protected EntityManager em=null;
	private Class entidadeGenerica;
	public RepositorioGenerico() {
		this.em = ConexaoFactory.getConexao();
	}
	public void incluir(T t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}
	public <T>T buscar(Integer id) {
		return (T) em.find(entidadeGenerica, id);
	}
	public void alterar(T t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	} 
}
