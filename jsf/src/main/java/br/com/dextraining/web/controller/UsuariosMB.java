package br.com.dextraining.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.dextraining.domain.Usuario;
import br.com.dextraining.domain.UsuarioService;

@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuariosMB {

	private List<Usuario> usuarios;

	private Usuario usuario;

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	public void carregar() {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		
		LoginMB loginMB = (LoginMB) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "loginMB");
		loginMB.assertLogged();
		this.usuarios = UsuarioService.listar();
	}

	public String salvar() {
		UsuarioService.salvar(usuario);
		FacesUtils.createSuccessMessage("Usuario cadastrado com Sucesso!");
		return "listagem?faces-redirect=true";
	}

	public String irParaNovoUsuario() {
		this.usuario = new Usuario();
		return "novoUsuario?faces-redirect=true";
	}
	
	public String mostrarSenha(){
		return usuario.getSenha();
	}

}
