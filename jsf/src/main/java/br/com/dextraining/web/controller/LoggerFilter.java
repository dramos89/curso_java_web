package br.com.dextraining.web.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoggerFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Inicializando FIlter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("Antes de Processar: " + req.getHeader("Host"));
		
		chain.doFilter(request, response);
		
		System.out.println("Despois de Processar: " + req.getHeader("Host"));
		
	}

	@Override
	public void destroy() {
		System.out.println("Destruindo FIlter");
	}

}
