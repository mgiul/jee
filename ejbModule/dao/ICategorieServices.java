package dao;



import java.util.List;

import javax.ejb.Remote;

import entities.Categorie;

@Remote
public interface ICategorieServices {
	public Long addCategorie(Categorie categorie);
	public List<Categorie> AllCategorie();
	public Categorie getCategorie(Long id_cat);
	public void removeCategorie(Long id_cat);
	public void updateCategorie(Categorie categorie);
}
