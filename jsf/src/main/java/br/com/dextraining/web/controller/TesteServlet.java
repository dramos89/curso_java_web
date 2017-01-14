package br.com.dextraining.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

public class TesteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("ISO-8859-1");

		PrintWriter writer = resp.getWriter();
		writer.write("<html><body><h1>" + req.getSession().getAttribute("VALOR") + "</h1></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().setAttribute("VALOR", req.getParameter("valor"));
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("teste.html");
		dispatcher.forward(req, resp);
	}

	
}
