package metier;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.IClientServices;
import entities.Client;

@Stateless
public class IClientServivesImpl implements IClientServices{
@PersistenceContext
private EntityManager em;
	
	public Client authenticate(String login, String password) {
		
		Client client=null;	
		Query qr=em.createQuery("select cl from Client cl where cl.email=:login and cl.password=:password");
		qr.setParameter("login", login);
		qr.setParameter("password", password);
		if(qr.getResultList().isEmpty())
		{
			client=null;   
		}
		if(qr.getResultList().size()>1)
		{
			client=null;
		}
		if(qr.getResultList().size()==1)
		{
			client=(Client) qr.getSingleResult();
		}
		return client;
}

	@Override
	public Long AddClient(Client client) {
		em.persist(client);
		return client.getIdClient();
	}

	@Override
	public Client getClient(Long id_cl) {
	Client client=em.find(Client.class, id_cl);
		return client;
	}

	@Override
	public void removeClient(Long id_cl) {
		Client client=em.find(Client.class, id_cl);
		em.remove(client);
		
	}

	@Override
	public void updateClient(Client client) {
		em.merge(client);
		
	}
}
