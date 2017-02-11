package br.com.dextra.treinamento.controller.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.dextra.treinamento.model.domain.Post;
import br.com.dextra.treinamento.model.service.jpa.PostServiceLocal;

@ManagedBean(name = "listarPostsMB")
@SessionScoped
public class ListarPostsMB {

	private static final String INDEX_XHTML = "index.xhtml";

	private static final String INCLUIR_POST = "incluirPost.xhtml";

	private static final String LISTAR_POSTS = "listarPosts.xhtml";
	
	private static final String ALTERAR_POST = "alterarPost.xhtml";

	private List<Post> posts;

	private Post post = new Post();

	private Post novoPost;
	
	@EJB
	private PostServiceLocal postServiceLocal;

	public String listar() {
		posts = postServiceLocal.listar();
		return LISTAR_POSTS;
	}

	public String incluir() {
		this.novoPost = new Post();
		return INCLUIR_POST;
	}

	public String salvar() {
		this.postServiceLocal.salvar(novoPost);
		return this.listar();
	}

	public String cancelar() {
		return this.listar();
	}

	public String prepararAlteracao() {
		Long id = Long.valueOf(getIdContext("id"));
		post = this.postServiceLocal.findById(id);
		return ALTERAR_POST;
		//this.salvar();
		//posts.
		//post.setTitulo(titulo);
		//this.postServiceLocal.salvar(post);
	}
	
	public String alterar(){
		this.postServiceLocal.salvar(post);
		return listar();
	}

	public String remover() {
		Long id = Long.valueOf(getIdContext("id"));
		this.postServiceLocal.excluir(Long.valueOf(id));
		return this.listar();
	}

	public String voltar() {
		return INDEX_XHTML;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post getNovoPost() {
		return novoPost;
	}

	public void setNovoPost(Post novoPost) {
		this.novoPost = novoPost;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	private String getIdContext(String nome){
		return (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(nome);
	}
}
