package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Commande  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCommande;
	@Temporal(TemporalType.DATE)
	private  Date dateCommande;
	@OneToMany(mappedBy="commande")
	private Collection<LigneCommande> items;
	public Collection<LigneCommande> getItems() {
		return items;
	}


	public void setItems(Collection<LigneCommande> items) {
		this.items = items;
	}
	@ManyToOne
	@JoinColumn(name="REF_CLIENT")
	private Client client;
	
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande =dateCommande ;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
