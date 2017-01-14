package br.com.dextraining.web.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="loginMB")
public class LoginMB {
	private String login;
	private String pass;
	private String result;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void doLogin(){
		this.result = new loginDAO().doLogin(this.getLogin(), this.getPass());
	}
	
}
