package entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class LigneCommande  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCommande;
	private int quatite;
	@ManyToOne
	@JoinColumn(name="REF_PROD")
	private Produit produit;
	private double prix;
	@ManyToOne
	@JoinColumn(name="REF_COM")
	private Commande commande;
	
	
	
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public LigneCommande( int quatite, double prix) {
		super();
		
		this.quatite = quatite;
		this.prix = prix;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQuatite() {
		return quatite;
	}
	public void setQuatite(int quatite) {
		this.quatite = quatite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

}
