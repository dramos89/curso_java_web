package br.com.dextraining.web.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "initMB")
public class InitMB {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome + "-Ok";
	}

	public void salvar() {
		System.out.println("Salvo: " + nome);
	}
	
	
}
