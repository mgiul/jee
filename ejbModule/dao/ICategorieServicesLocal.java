package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Categorie;


@Local
public interface ICategorieServicesLocal {
	public Long addCategorie(Categorie categorie);
	public List<Categorie> AllCategorie();
	public Categorie getCategorie(Long id_cat);
	public void removeCategorie(Long id_cat);
	public void updateCategorie(Categorie categorie);
}
