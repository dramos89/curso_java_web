package br.com.javaweb.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javaweb.gerenciador.Usuario;
import br.com.javaweb.gerenciador.dao.UsuarioDAO;

/**
 * Servlet implementation class Autenticacao
 */
@WebServlet("/autenticacao_cookie")
public class AutenticacaoCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticacaoCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		//PrintWriter writer = response.getWriter();
		UsuarioDAO usu = new UsuarioDAO();
		Usuario usuario = usu.buscaPorEmailESenha(email, senha);
		
		if (usuario != null){
			Cookie cookie = new Cookie("usuario.logado", email);
			response.addCookie(cookie);
			response.sendRedirect("/ExemploServlets/index.html");
		} else {
			response.sendRedirect("/ExemploServlets/erro.html");
		}	
			
	}

}
