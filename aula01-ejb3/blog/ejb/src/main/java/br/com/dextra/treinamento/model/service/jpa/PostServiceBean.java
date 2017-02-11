package br.com.dextra.treinamento.model.service.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.dextra.treinamento.model.domain.Post;

@Stateless
public class PostServiceBean implements PostServiceLocal{

	@PersistenceContext(unitName="blog-pu")
	private EntityManager em;
	
	public void salvar(Post p) {
		em.merge(p); //insere ou altera
		//em.persist(p); //apenas insere, pode gerar erro se o item já existe.
	}
	
	public List<Post> listar() {
		String sql = "FROM Post";
		Query query = em.createQuery(sql);
		return query.getResultList();
	}

	@Override
	public void excluir(Long id) {
		Post postDelete = this.findById(id);
		em.remove(postDelete);		
	}

	@Override
	public Post findById(Long id) {
		return em.find(Post.class, id);
	}
	
}
