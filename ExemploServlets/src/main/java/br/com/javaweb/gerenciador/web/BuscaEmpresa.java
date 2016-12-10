




package br.com.javaweb.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.Request;

import br.com.javaweb.gerenciador.Empresa;
import br.com.javaweb.gerenciador.dao.EmpresaDAO;

/**
 * Servlet implementation class BuscaEmpresa
 */
@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {
	String filtro;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaEmpresa() {
        super();
        System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa" + this);
         //TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //TODO Auto-generated method stub
		String filtro = request.getParameter("filtro");
		/* Pausa do processamento da thread que monitora a servlet
		 * 
		 * try{
			Thread.sleep(5000);
		}catch (InterruptedException e){
			e.printStackTrace();
		}*/
		Collection<Empresa> filtroEmpresa = new EmpresaDAO().buscaPorSimilaridade(filtro);

		request.setAttribute("empresas", filtroEmpresa);
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp"); 
		
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

	@Override
	public void init() throws ServletException {
		 //TODO Auto-generated method stub
		super.init();
		System.out.println("Inicializando servlet " + this);
	}
	
	@Override
	public void destroy() {
		 //TODO Auto-generated method stub
		super.destroy();
		System.out.println("Destruindo servlet " + this);
	}
}
