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
		Query qr=em.createQuery("select ad from Admin ad where ad.nomAdmin=:login and ad.passwordAdmin=:password");
		qr.setParameter("login", login);
		qr.setParameter("password", password);
		return (Admin) qr.getSingleResult();
	}

}
