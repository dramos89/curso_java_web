package br.com.dextra.treinamento.model.service.sessionbean;

import java.util.List;

import br.com.dextra.treinamento.model.domain.Post;

public interface PostManagerLocal {

	public void insertPost();
	
	public List<Post> listPost();

	Post insertPost(Post insertPost);
}
