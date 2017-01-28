package br.com.dextraining.web.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.dextraining.domain.Usuario;
import br.com.dextraining.domain.UsuarioService;

@ManagedBean
@SessionScoped
public class LoginMB {

	private Usuario usuario = new Usuario();

	private boolean logado;

	private UsuarioService service = new UsuarioService();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public void login() {
		this.logado = UsuarioService.logar(this.usuario);
		if (this.logado) {
			FacesUtils.redirect("usuario/listagem.jsf");
		}
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.jsf?faces-redirect=true";
	}

	public void assertLogged() {
		if (!isLogado()) {
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			FacesUtils.createErrorMessage("Usuario Nao Logado");
			FacesUtils.redirect("/login.jsf");
		}
	}

}
