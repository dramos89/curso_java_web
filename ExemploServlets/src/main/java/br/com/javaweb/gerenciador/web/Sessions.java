package br.com.javaweb.gerenciador.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.javaweb.gerenciador.Usuario;

public class Sessions {

	
	
	public String getUsuario(HttpServletRequest req){
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.logado");
		if (usuario == null)
			return "<deslogado>";
		return usuario.getEmail();
	}
}
