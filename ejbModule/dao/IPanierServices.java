package dao;




import java.util.Collection;
import java.util.List;

import javax.ejb.Remote;

import entities.Client;
import entities.Commande;
import entities.LigneCommande;

import entities.Produit;
@Remote
public interface IPanierServices {
	public void addProduit(Produit produit,int quantite) ;
	public Collection<LigneCommande> getAllLigneCommande() ;
	public double getTotal();
	public int  getSize();
	public void delete(Long id_prod) ;
	public Commande enregistrerCommande(Client client);

}
