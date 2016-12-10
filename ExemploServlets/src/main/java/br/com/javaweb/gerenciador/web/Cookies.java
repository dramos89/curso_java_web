package br.com.javaweb.gerenciador.web;

import javax.servlet.http.Cookie;

import br.com.javaweb.gerenciador.Usuario;

public class Cookies {

	private final Cookie[] cookies;
	
	public Cookies(Cookie[] cookies){
		this.cookies = cookies;
	}
	
	public Cookie getUsuario(){
		if (this.cookies == null)
			return null;
		for (Cookie cookie : this.cookies) {
			if (cookie.getName()
					.equals("usuario.logado")){
				return cookie;
			}
			
		}
		return null;
	}
}
