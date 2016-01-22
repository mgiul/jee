package metier;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.ICommandeServices;
import entities.LigneCommande;
@Stateless
public class ICommandeServicesImpl implements ICommandeServices {
	@PersistenceContext
	private EntityManager em;
	@Override
	public ArrayList<LigneCommande> getAllCommandes() {
		Query qr=em.createQuery("select com from LigneCommande com");
		
		return (ArrayList<LigneCommande> ) qr.getResultList();
	}

}
