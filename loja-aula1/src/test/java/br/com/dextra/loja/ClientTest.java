package br.com.dextra.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.dextra.loja.dao.CarrinhoDAO;
import br.com.dextra.loja.modelo.Carrinho;
import br.com.dextra.loja.modelo.Produto;

public class ClientTest {

	private HttpServer server;

	@After
	public void stopServerTest() {
		this.server.stop();
	}

	@Before
	public void startServerTest() {
		this.server = Servidor.startServer();
	}

	@Test
	public void testJsonReturn() {
		Client client = ClientBuilder.newClient();
		// WebTarget target = client.target("http://www.mocky.io");
		// String conteudo =
		// target.path("v2/54eb56c0fab2e6f405edbaab").request().get(String.class);

		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/carrinhos").queryParam("id", 1).request().get(String.class);

		Carrinho carrinho = new Gson().fromJson(conteudo, Carrinho.class);

		Assert.assertEquals("Polo de Tecnologia", carrinho.getRua());

		System.out.println(conteudo);

	}

	@Test
	public void testXmlReturn() {
		Client client = ClientBuilder.newClient();
		// WebTarget target = client.target("http://www.mocky.io");
		// String conteudo =
		// target.path("v2/54eb56c0fab2e6f405edbaab").request().get(String.class);

		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/carrinhos/1").request().get(String.class);

		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);

		Assert.assertEquals("Polo de Tecnologia", carrinho.getRua());

		System.out.println(conteudo);

	}

	@Test
	public void testXmlAdd() {
		Client client = ClientBuilder.newClient();
		// WebTarget target = client.target("http://www.mocky.io");
		// String conteudo =
		// target.path("v2/54eb56c0fab2e6f405edbaab").request().get(String.class);

		WebTarget target = client.target("http://localhost:8080");
		// String conteudo =
		// target.path("/carrinhos/1").request().get(String.class);

		Carrinho carrinho = new Carrinho();
		Produto produto = new Produto(3, "Cerveja Bohemia", 3.5, 5);

		carrinho.adiciona(produto);
		carrinho.setCidade("Campinas");
		carrinho.setId(3);
		carrinho.setRua("Polis");

		String convertCarrinhoToXml = carrinho.toXML();

		Entity<String> entity = Entity.entity(convertCarrinhoToXml, javax.ws.rs.core.MediaType.APPLICATION_XML);

		Response response = target.path("/carrinhos").request().post(entity);

		Assert.assertEquals(201, response.getStatus());
	}

	@Test
	public void testJsonAdd() {
		Client client = ClientBuilder.newClient();
		// WebTarget target = client.target("http://www.mocky.io");
		// String conteudo =
		// target.path("v2/54eb56c0fab2e6f405edbaab").request().get(String.class);

		WebTarget target = client.target("http://localhost:8080");
		// String conteudo =
		// target.path("/carrinhos/1").request().get(String.class);

		Carrinho carrinho = new Carrinho();
		Produto produto = new Produto(3, "Cerveja Bohemia", 3.5, 5);

		carrinho.adiciona(produto);
		carrinho.setCidade("Campinas");
		carrinho.setId(3);
		carrinho.setRua("Polis");

		String convertCarrinhoToJson = carrinho.toJSON();

		Entity<String> entity = Entity.entity(convertCarrinhoToJson, javax.ws.rs.core.MediaType.APPLICATION_JSON);

		Response response = target.path("/carrinhos").request().post(entity);

		Assert.assertEquals(201, response.getStatus());
	}
	@Test
	public void testUpdateProduct(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Produto produto = new Produto(3467, "Cerveja Bohemia", 3.5, 5);
		String produtoEmXml = new XStream().toXML(produto);
		
		Entity<String> entity = Entity.entity(produtoEmXml, javax.ws.rs.core.MediaType.APPLICATION_XML);
		
		Response response = target.path("/carrinhos/1/produtos/3467").request().put(entity);
		
		Assert.assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testUpdateQuantityProduct(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Produto produto = new Produto(3, "Cerveja Bohemia", 3.5, 5);
		String produtoEmXml = new XStream().toXML(produto);
		
		Entity<String> entity = Entity.entity(produtoEmXml, javax.ws.rs.core.MediaType.APPLICATION_XML);
		
		Response response = target.path("/carrinhos/1/produtos/3467/quantidade").request().put(entity);
		
		Assert.assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testaAtualizaCarrinho() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");		
		Produto produto = new Produto(3467, "Cerveja Duvel", 8.5, 1);
		String converteProdutoXML = new XStream().toXML(produto);
		
		Entity<String> entity = Entity.entity(converteProdutoXML, 
				javax.ws.rs.core.MediaType.APPLICATION_XML);
		
		Response response = target.path("/carrinhos/1/produtos/3467")
				.request().put(entity);
		Assert.assertEquals(200, response.getStatus());
	}

	@Test
	public void testDeleteProduct(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		
		Response response = target.path("/carrinhos/1/produtos/6237").request().delete();
		
		Assert.assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testDeleteCarrinho(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		
		Response response = target.path("/carrinhos/1").request().delete();
		
		Assert.assertEquals(200, response.getStatus());
	}
	
}
