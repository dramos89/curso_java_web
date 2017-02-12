package br.com.dextra.treinamento.model.service.jpa;

import java.util.List;

import javax.ejb.Local;

import br.com.dextra.treinamento.model.domain.Post;

@Local
public interface PostServiceLocal {
	
	public void salvar(Post p);
	
	public List<Post> listar();
	
	public void excluir(Long id);

	public Post findById(Long id);

}
