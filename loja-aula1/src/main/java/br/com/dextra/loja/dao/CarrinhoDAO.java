package br.com.dextra.loja.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import br.com.dextra.loja.modelo.Carrinho;
import br.com.dextra.loja.modelo.Produto;

public class CarrinhoDAO {

	private static Map<Long, Carrinho> banco = new HashMap<Long, Carrinho>();
	private static AtomicLong contador = new AtomicLong(1);

	static {
		Produto cervejaDevassa = new Produto(6237, "Cerveja Devassa", 3.00, 1);
		Produto cervejaProibida = new Produto(3467, "Cerveja Proibida", 2.50, 2);
		Carrinho carrinho = new Carrinho().adiciona(cervejaDevassa).adiciona(cervejaProibida)
				.para("Polo de Tecnologia", "Campinas - SP").setId(1l);
		banco.put(1l, carrinho);
	}

	public void add(Carrinho carrinho) {
		long id = contador.incrementAndGet();
		carrinho.setId(id);
		banco.put(id, carrinho);
	}

	public Carrinho search(Long id) {
		return banco.get(id);
	}

	public Carrinho remove(long id) {
		return banco.remove(id);
	}

}
