package pk.com.proj.enciclothias.model.service.sessionbean;

import java.util.List;

import pk.com.proj.enciclothias.model.domain.Post;

public interface PostManagerLocal {

	public void insertPost();
	
	public List<Post> listPost();

	Post insertPost(Post insertPost);
}
