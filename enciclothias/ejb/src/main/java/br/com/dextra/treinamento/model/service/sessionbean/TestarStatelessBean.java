package br.com.dextra.treinamento.model.service.sessionbean;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import br.com.dextra.treinamento.model.service.interceptor.LoginInterceptor;

@Stateless
@Interceptors(value=LoginInterceptor.class)
public class TestarStatelessBean implements TestarStatelessLocal {

	private Integer contador = 0;
	@Override
	public Integer adicionar() {
		this.contador++;
		return this.contador;
	}

}
