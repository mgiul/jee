package metier;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.ProduitServices;
import entities.Categorie;
import entities.Produit;



@Stateless
public class ProduitImpl implements ProduitServices {
	  @PersistenceContext
	    private EntityManager em;
	@Override
	public Long AddProduct(Produit produit,Long id_cat) {
		Categorie categorie=em.find(Categorie.class, id_cat);
		produit.setCategorie(categorie);
		em.persist(produit);
		return produit.getIdProduit();
	
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getAllProduits() {
		Query qr=em.createQuery("select pr from Produit pr ");
		return qr.getResultList();
	}
	@Override
	public List<Produit> getProduitsParMC(String mc) {
		Query qr=em.createQuery("select pr from Produit pr  where pr.designation like :x");
		qr.setParameter("x","%"+mc+"%");
		return qr.getResultList();
	}
	@Override
	public Produit getProduit(Long id_pr) {
	Produit pr=em.find(Produit.class, id_pr);
		return pr;
	}
	@Override
	public void removeProduit(Long id_pr) {
		Produit pr=em.find(Produit.class, id_pr);
		
	}
	@Override
	public void updateProduit(Produit produit) {
		em.merge(produit);
		
	}
	@Override
	public List<Produit> getProduitsParCategorie(Long id_cat) {
		Query qr=em.createQuery("select p from Produit p where p.categorie.idCategorie=:x");
		qr.setParameter("x", id_cat);
		return qr.getResultList();
	}

}
