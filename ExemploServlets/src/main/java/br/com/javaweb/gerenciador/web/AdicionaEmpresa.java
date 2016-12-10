package br.com.javaweb.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NOTATIONDatatypeValidator;

import br.com.javaweb.gerenciador.Empresa;
import br.com.javaweb.gerenciador.dao.EmpresaDAO;

/**
 * Servlet implementation class AdicionaEmpresa
 */
@WebServlet("/adicionaEmpresa")
public class AdicionaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaEmpresa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//adicionar(request.getParameter("nome"));
	//capturando o valor do campo da pagina JSP
	Empresa empresa = adicionar(request.getParameter("nome"));
	//setando valor para um atributo da pagina JSP
	request.setAttribute("empresa", empresa.getNome());
	
	RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
	disp.forward(request, response);
	}	
	
	private Empresa adicionar(String parametro){
		Empresa novaEmpresa = new Empresa(parametro);
		
		EmpresaDAO dao = new EmpresaDAO();
		dao.adiciona(novaEmpresa);
		return novaEmpresa;
	}
	
	

}
