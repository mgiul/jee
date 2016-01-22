package metier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.IAdminServices;
import entities.Admin;
import entities.Client;
@Stateless
public class IAdminServicesImpl implements IAdminServices {
@PersistenceContext
private EntityManager em;

	@Override
	public Long AddAdmin(Admin admin) {
		em.persist(admin);
		return admin.getIdAdmin();
	}

	@Override
	public Admin getAdmin(Long id_ad) {
		Admin admin=em.find(Admin.class, id_ad);
		return admin;
	}

	@Override
	public void removeAdmin(Long id_ad) {
		Admin admin=em.find(Admin.class, id_ad);
		em.remove(admin);
		
	}

	@Override
	public void updateAdmin(Admin admin) {
		em.merge(admin);
		
	}

	@Override
	public Admin authenticate(String login, String password) {		
		Admin admin=null;	
		Query qr=em.createQuery("select ad from Admin ad where ad.nomAdmin=:login and ad.passwordAdmin=:password");
		qr.setParameter("login", login);
		qr.setParameter("password", password);
		if(qr.getResultList().isEmpty())
		{
			admin=null;   
		}
		if(qr.getResultList().size()>1)
		{
			admin=null;
		}
		if(qr.getResultList().size()==1)
		{
			admin=(Admin) qr.getSingleResult();
		}
		return admin;
		
		
	}

}
