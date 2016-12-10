package br.com.javaweb.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.javaweb.gerenciador.Usuario;
import br.com.javaweb.gerenciador.dao.UsuarioDAO;

/**
 * Servlet implementation class Autenticacao
 */
@WebServlet("/autenticacao")
public class Autenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autenticacao() {
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
		//doGet(request, response);
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		//PrintWriter writer = response.getWriter();
		UsuarioDAO usu = new UsuarioDAO();
		Usuario usuario = usu.buscaPorEmailESenha(email, senha);
		RequestDispatcher dispatcher;
		if (usuario != null){
			HttpSession session = request.getSession();
			session.setAttribute("usuario.logado", usuario);
		    dispatcher = request.getRequestDispatcher("WEB-INF/paginas/index.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("WEB-INF/paginas/erro.html");
		}	
		dispatcher.forward(request, response);
			
	}

}
