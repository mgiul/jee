package metier;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.ICategorieServices;
import entities.Categorie;

@Stateless
public class ICategorieServicesImpl  implements ICategorieServices {
@PersistenceContext
private EntityManager em;
	@Override
	public Long addCategorie(Categorie categorie) {
		em.persist(categorie);
		return categorie.getIdCategorie();
	}

	@Override
	public List<Categorie> AllCategorie() {
	Query qr=em.createQuery("select cat from Categorie cat");
	
		return qr.getResultList();
	}

	@Override
	public Categorie getCategorie(Long id_cat) {
		
		return em.find(Categorie.class, id_cat);
	}

	@Override
	public void removeCategorie(Long id_cat) {
		Categorie categorie=em.find(Categorie.class, id_cat);
		em.remove(categorie);
		
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		em.merge(categorie);
		
	}

}
