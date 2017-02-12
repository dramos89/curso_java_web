package br.com.dextra.treinamento.model.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.dextra.curso.hibernate.util.JPAUtils;
import br.com.dextra.treinamento.model.domain.Post;

public class PostServiceImpl {

	private static PostServiceImpl instance = new PostServiceImpl();

	public static PostServiceImpl getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Post> listar() {
		EntityManager em = JPAUtils.emf.createEntityManager();
		String hql = "FROM Post";
		
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	public void salvar(Post p) {
		EntityManager em = JPAUtils.emf.createEntityManager();
		
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();

			em.merge(p);

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			throw e;

		} finally {
			em.close();
		}
	}
}
