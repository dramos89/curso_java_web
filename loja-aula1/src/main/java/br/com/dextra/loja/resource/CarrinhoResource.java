package br.com.dextra.loja.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.util.HttpStatus;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.dextra.loja.dao.CarrinhoDAO;
import br.com.dextra.loja.modelo.Carrinho;
import br.com.dextra.loja.modelo.Produto;

@Path("carrinhos")
public class CarrinhoResource {

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String searchWithId(@PathParam("id") long id) {
		Carrinho carrinho = new CarrinhoDAO().search(id);
		return carrinho.toXML();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// Da forma abaixo é implementado usando o ?id=1 no final da URI
	public String search(@QueryParam("id") long id) {
		Carrinho carrinho = new CarrinhoDAO().search(id);
		return carrinho.toJSON();
	}
	
//	
//	@POST
//	@Consumes(MediaType.APPLICATION_XML)
//	public String add(String content){
//		Carrinho carrinho = (Carrinho) new XStream().fromXML(content);
//	    new CarrinhoDAO().add(carrinho);
//		return "Success";
//	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addByJson(String content){
		Carrinho carrinho = new Gson().fromJson(content, Carrinho.class);
		new CarrinhoDAO().add(carrinho);
		//cria uri para 
		URI uri = URI.create("/carrinhos/"+carrinho.getId());
		//traz o statuscode da requisição.
		return Response.created(uri).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response add(String content){
		Carrinho carrinho = (Carrinho) new XStream().fromXML(content);
		new CarrinhoDAO().add(carrinho);
		URI uri = URI.create("/carrinhos/"+carrinho.getId());
		//traz o statuscode da requisição.
		return Response.created(uri).build();
	}
	
	@Path("{id}/produtos/{productId}")
	@DELETE
	public Response removeProduct(@PathParam("id") long id, @PathParam("productId") long productId){
		Carrinho carrinho = new CarrinhoDAO().search(id);
		carrinho.remove(productId);
		return Response.ok().build();
	}
	
	
	@Path("{id}")
	@DELETE
	public Response removeCarrinho(@PathParam("id") long id){
		new CarrinhoDAO().remove(id);
		return Response.ok().build();
	}
	
	@Path("{id}/produtos/{productId}")
	@PUT
	public Response updateProduct(String newProduct, @PathParam("id") long id, @PathParam("productId") long productId){
		Carrinho carrinho = new CarrinhoDAO().search(id);
		Produto product = (Produto) new XStream().fromXML(newProduct);
		carrinho.troca(product);
		return Response.ok().build();
	}
	
	@Path("{id}/produtos/{productId}/quantidade")
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateProductQuantity(String newProductQuantity, @PathParam("id") long id, @PathParam("productId") long productId){
		Carrinho carrinho = new CarrinhoDAO().search(id);
		Produto product = (Produto) new XStream().fromXML(newProductQuantity);
		carrinho.trocaQuantidade(product);
		return Response.ok().build();
	}
	
	@Path("{id}/produtos/{produtoId}/quantidadeJSON")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProductQuantityJson(String newProductQuantity, @PathParam("id")long id, @PathParam("productId") long productId){
		Carrinho carrinho = new CarrinhoDAO().search(id);
		Produto product = (Produto) new Gson().fromJson(newProductQuantity, Produto.class);
		carrinho.trocaQuantidade(product);
		return Response.ok().build();
	}
	
	

}
