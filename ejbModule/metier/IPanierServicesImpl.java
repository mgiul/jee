package metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.IPanierServices;
import entities.Client;
import entities.Commande;
import entities.LigneCommande;
import entities.Produit;

@Stateful
public class IPanierServicesImpl implements IPanierServices {
	  @PersistenceContext
	    private EntityManager em;

	private Map<Long,LigneCommande> items = new HashMap<Long,LigneCommande>();
	
	public IPanierServicesImpl() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void addProduit(Produit produit,int quantite) {
		if(items.get(produit.getIdProduit())==null){
		LigneCommande lc=new LigneCommande();
		lc.setProduit(produit);
		lc.setPrix(produit.getPrix()*quantite);
		lc.setQuatite(quantite);
		items.put(produit.getIdProduit(),lc);
		
			}else {
				LigneCommande lc=items.get(produit.getIdProduit());
				lc.setQuatite(quantite+lc.getQuatite());
				lc.setPrix(produit.getPrix()*lc.getQuatite());
				items.remove(produit.getIdProduit());
				items.put(produit.getIdProduit(),lc);
				
			}
		
	}

	public double getTotal() {
		double total=0;
		for (LigneCommande ligneCommande : items.values()) {
			total+=ligneCommande.getPrix();
		}
		return total;
	}
	public int  getSize() {
		return items.size();
	}
	public void delete(Long id_prod) {
		items.remove(id_prod);
	}
	@Override
	public Commande enregistrerCommande(Client client) {
		em.persist(client);
		Commande cmd=new Commande();
		cmd.setDateCommande(new Date());
		cmd.setItems(items.values());
		for (LigneCommande ligneCommande : items.values()) {
			em.persist(ligneCommande);
		}
		em.persist(cmd);
		return cmd;
		
		
	}
	
	
	public Map<Long, LigneCommande> getItems() {
		return items;
	}

	public void setItems(Map<Long, LigneCommande> items) {
		this.items = items;
	}

	public boolean  isPossible(int id,double solde){
		return true;
	}
	public void retirer(int id,double solde){
		
	}
	public boolean login(String email,String pass){
		return false;
	}


}
