package br.com.dextra.treinamento.model.service.sessionbean;

import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

import br.com.dextra.treinamento.model.service.interceptor.LoginInterceptor;

@Stateful
@Interceptors(value=LoginInterceptor.class)
public class TestarStatefulBean implements TestarStatefulLocal{
	
	private Integer contador = 0;

	@Override
	public Integer adicionar() {
		this.contador++;
		return this.contador;
	}

}