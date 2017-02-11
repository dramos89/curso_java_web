package br.com.dextra.treinamento.controller.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.dextra.treinamento.model.domain.Categoria;
import br.com.dextra.treinamento.model.domain.Post;
import br.com.dextra.treinamento.model.service.PostServiceImpl;

@ManagedBean(name = "listarPostsMB")
@SessionScoped
public class ListarPostsMB {

	private String titulo;
	
	private String descricao;
	
	private Categoria categoria;

	private List<Categoria> possiveisCategorias;
	
	List<Post> posts;

	private Post novoPost;
	
	public String listar() {
		PostServiceImpl postService = PostServiceImpl.getInstance();
		posts = postService.listar();
		
		return "listarPosts.xhtml";
	}
	
	public void adicionarMensagem(String mensagem) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		FacesMessage facesMessage = new FacesMessage(mensagem);
		facesContext.addMessage(null, facesMessage);
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String incluir() {
		this.novoPost = new Post();
		
		return "incluirPost.xhtml";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Categoria> getPossiveisCategorias() {
		return possiveisCategorias;
	}

	public void setPossiveisCategorias(List<Categoria> possiveisCategorias) {
		this.possiveisCategorias = possiveisCategorias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String salvar() {
		PostServiceImpl postService = PostServiceImpl.getInstance();
		postService.salvar(novoPost);
		
		posts = postService.listar();
		
		return "listarPosts.xhtml";
	}
	
	public String cancelar() {
		return "listarPosts.xhtml";
	}

	public Post getNovoPost() {
		return novoPost;
	}

	public void setNovoPost(Post novoPost) {
		this.novoPost = novoPost;
	}
}
