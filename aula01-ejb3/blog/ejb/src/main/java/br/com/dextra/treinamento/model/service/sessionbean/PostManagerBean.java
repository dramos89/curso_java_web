package br.com.dextra.treinamento.model.service.sessionbean;

import java.util.List;

import javax.ejb.Stateless;

import br.com.dextra.treinamento.model.domain.Post;

@Stateless
public class PostManagerBean implements PostManagerRemote, PostManagerLocal {

	@Override
	public Post insertPost(Post insertPost) {
		// TODO Auto-generated method stub
		Post newPost = new Post(insertPost.getTitulo(),insertPost.getDescricao());
		return newPost;
	}

	@Override
	public List<Post> listPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertPost() {
		// TODO Auto-generated method stub
		
	}

}
