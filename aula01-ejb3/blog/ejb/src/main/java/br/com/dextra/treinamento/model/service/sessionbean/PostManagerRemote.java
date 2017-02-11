package br.com.dextra.treinamento.model.service.sessionbean;

import javax.ejb.Remote;

@Remote
public interface PostManagerRemote {

	public void insertPost();
}
