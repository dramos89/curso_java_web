package pk.com.proj.enciclothias.controller.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import pk.com.proj.enciclothias.model.service.sessionbean.TestarStatefulLocal;
import pk.com.proj.enciclothias.model.service.sessionbean.TestarStatelessLocal;

@ManagedBean(name = "testarSessionBeanMB")
@RequestScoped
public class TestarSessionBeanMB {

	private static final String LOCAL_STATELESS = "blog/TestarStatelessBean/local";
	private static final String LOCAL_STATEFUL = "blog/TestarStatefulBean/local";
	private String contador;

	public String getContador() {
		return contador;
	}

	public void setContador(String contador) {
		this.contador = contador;
	}

	// exemplo de lookup
	public void testarStateless() {
		try {
		
			List<Integer> list = new ArrayList<Integer>();
			InitialContext cxt = new InitialContext();
			TestarStatelessLocal local = (TestarStatelessLocal) cxt.lookup(LOCAL_STATELESS);
			list.add(local.adicionar());
			local = (TestarStatelessLocal) cxt.lookup(LOCAL_STATELESS);
			list.add(local.adicionar());
			System.out.println("Resultado stateless: "+ list.toString());
			setContador(list.toString());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testarStateful() {

		try {

			
			List<Integer> list = new ArrayList<Integer>();
			InitialContext cxt = new InitialContext();
			TestarStatefulLocal local = (TestarStatefulLocal) cxt.lookup(LOCAL_STATEFUL);
			list.add(local.adicionar());
			local = (TestarStatefulLocal) cxt.lookup(LOCAL_STATEFUL);
			list.add(local.adicionar());
			System.out.println("Resultado stateful: "+ list.toString());
			setContador(list.toString());

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
