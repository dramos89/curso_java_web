package pk.com.proj.enciclothias.model.service.interceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.interceptor.InvocationContext;

public class LoginInterceptor {

	@PostConstruct
	public void construct(InvocationContext ctx){
		System.out.println("EJB foi criado. Classe: "+ getNameContext(ctx));
	}
	
	@PreDestroy
	public void destroy(InvocationContext ctx){
		System.out.println("EJB foi destruído. Classe: "+ getNameContext(ctx));
	}
	
	@PrePassivate
	public void passivate(InvocationContext ctx){
		System.out.println("EJB foi passivado. Classe: "+ getNameContext(ctx));
	}
	
	@PostActivate
	public void activate(InvocationContext ctx){
		System.out.println("EJB foi ativado. Classe: "+ getNameContext(ctx));
	}
	
	private String getNameContext(InvocationContext ctx){
		return ctx.getTarget().getClass().getSimpleName();
	}
}
