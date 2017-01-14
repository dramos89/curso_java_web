package br.com.dextraining.web.controller;

public class loginDAO {
	private static final String LOGIN_DEFAULT = "jose@gmail.com";
	private static final String PASS_DEFAULT = "12345";

	public String doLogin(String login, String pass) {
		String loginProccess;
		if ((!login.equals("")) && (!pass.equals(""))) {
			if (login.equals(LOGIN_DEFAULT) && (pass.equals(PASS_DEFAULT))) {
				loginProccess = "Sucesso!";
			} else {
				loginProccess = "Login ou senha inválido";
			}

		} else {
			loginProccess = "Login ou senha vazios";
		}
		return loginProccess;
	}
}
