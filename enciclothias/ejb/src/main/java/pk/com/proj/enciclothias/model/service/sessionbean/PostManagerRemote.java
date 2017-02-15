package pk.com.proj.enciclothias.model.service.sessionbean;

import javax.ejb.Remote;

@Remote
public interface PostManagerRemote {

	public void insertPost();
}
